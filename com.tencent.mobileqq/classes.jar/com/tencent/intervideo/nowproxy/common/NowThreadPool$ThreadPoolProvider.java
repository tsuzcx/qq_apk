package com.tencent.intervideo.nowproxy.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public abstract interface NowThreadPool$ThreadPoolProvider
{
  public abstract ExecutorService getFixedThreadPool(int paramInt);
  
  public abstract ScheduledExecutorService getScheduledThreadPool(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.common.NowThreadPool.ThreadPoolProvider
 * JD-Core Version:    0.7.0.1
 */