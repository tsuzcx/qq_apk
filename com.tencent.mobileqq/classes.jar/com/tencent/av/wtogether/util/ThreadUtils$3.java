package com.tencent.av.wtogether.util;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

final class ThreadUtils$3
  implements Runnable
{
  ThreadUtils$3(ThreadUtils.1Result param1Result, Callable paramCallable, ThreadUtils.1CaughtException param1CaughtException, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    try
    {
      this.a.a = this.b.call();
    }
    catch (Exception localException)
    {
      this.c.a = localException;
    }
    this.d.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.util.ThreadUtils.3
 * JD-Core Version:    0.7.0.1
 */