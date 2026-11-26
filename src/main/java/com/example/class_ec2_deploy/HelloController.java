package com.example.class_ec2_deploy;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final StringRedisTemplate redis;

    public HelloController(StringRedisTemplate redis) {
        this.redis = redis;
    }

    @GetMapping("/")
    public String hello() {
        Long count = redis.opsForValue().increment("visits");
        return "안녕 반가워 - 방문횟수: " + count;
    }

    @GetMapping("/hi")
    public String hi() {
        return "Hi ~ 하이하이";
    }
}
