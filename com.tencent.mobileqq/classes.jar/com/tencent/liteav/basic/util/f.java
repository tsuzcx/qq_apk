package com.tencent.liteav.basic.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class f
  extends Handler
{
  public f(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public boolean a(Runnable paramRunnable)
  {
    return a(paramRunnable, -1L);
  }
  
  public boolean a(Runnable paramRunnable, long paramLong)
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    boolean bool = post(new f.1(this, paramRunnable, localCountDownLatch));
    if ((!bool) || (paramLong > 0L)) {}
    try
    {
      localCountDownLatch.await(paramLong, TimeUnit.MILLISECONDS);
      return bool;
    }
    catch (InterruptedException paramRunnable)
    {
      label59:
      break label59;
    }
    localCountDownLatch.await();
    return bool;
    Thread.currentThread().interrupt();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.f
 * JD-Core Version:    0.7.0.1
 */