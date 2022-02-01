package com.huawei.updatesdk.service.d.a;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class c
{
  public static final ThreadPoolExecutor a = new ThreadPoolExecutor(2, 2, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.d.a.c
 * JD-Core Version:    0.7.0.1
 */