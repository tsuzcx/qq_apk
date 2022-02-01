package com.tencent.mobileqq.app;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolParams
{
  public static final String DEFAULT_THREAD_NAME = "default_name";
  public int corePoolsize = 3;
  public int keepAliveTime = 1;
  public int maxPooolSize = 5;
  public String poolThreadName = "default_name";
  public int priority = 5;
  public BlockingQueue<Runnable> queue = new LinkedBlockingQueue(128);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadPoolParams
 * JD-Core Version:    0.7.0.1
 */