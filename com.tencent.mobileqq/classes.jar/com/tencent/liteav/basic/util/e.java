package com.tencent.liteav.basic.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;

public class e
  extends Handler
{
  public e(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public boolean a(Runnable paramRunnable)
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    boolean bool = post(new e.1(this, paramRunnable, localCountDownLatch));
    if (bool) {}
    try
    {
      localCountDownLatch.await();
      return bool;
    }
    catch (InterruptedException paramRunnable)
    {
      label34:
      break label34;
    }
    Thread.currentThread().interrupt();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.util.e
 * JD-Core Version:    0.7.0.1
 */