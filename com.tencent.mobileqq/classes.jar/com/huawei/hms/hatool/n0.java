package com.huawei.hms.hatool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class n0
{
  public static n0 b = new n0();
  public static n0 c = new n0();
  public ThreadPoolExecutor a;
  
  static
  {
    new n0();
    new n0();
  }
  
  public n0()
  {
    LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue(5000);
    this.a = new ThreadPoolExecutor(0, 1, 60000L, TimeUnit.MILLISECONDS, localLinkedBlockingQueue);
  }
  
  public static n0 a()
  {
    return c;
  }
  
  public static n0 b()
  {
    return b;
  }
  
  public void a(m0 paramm0)
  {
    try
    {
      this.a.execute(new n0.a(paramm0));
      return;
    }
    catch (RejectedExecutionException paramm0)
    {
      label16:
      break label16;
    }
    y.e("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.n0
 * JD-Core Version:    0.7.0.1
 */