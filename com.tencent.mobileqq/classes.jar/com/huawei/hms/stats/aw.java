package com.huawei.hms.stats;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class aw
{
  private static aw b = new aw();
  private static aw c = new aw();
  private static aw d;
  private static aw e = new aw();
  private ThreadPoolExecutor a;
  
  static
  {
    d = new aw();
  }
  
  private aw()
  {
    LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue(5000);
    this.a = new ThreadPoolExecutor(0, 1, 60000L, TimeUnit.MILLISECONDS, localLinkedBlockingQueue);
  }
  
  public static aw a()
  {
    return b;
  }
  
  public static aw b()
  {
    return c;
  }
  
  public void a(av paramav)
  {
    try
    {
      this.a.execute(new aw.a(paramav));
      return;
    }
    catch (RejectedExecutionException paramav)
    {
      af.c("TaskThread", "addToQueue() Exception has happened!Form rejected execution");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.aw
 * JD-Core Version:    0.7.0.1
 */