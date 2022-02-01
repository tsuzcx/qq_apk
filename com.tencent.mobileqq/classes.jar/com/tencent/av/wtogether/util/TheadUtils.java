package com.tencent.av.wtogether.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class TheadUtils
{
  public static <V> V a(Handler paramHandler, Callable<V> paramCallable)
  {
    if (paramHandler.getLooper().getThread() == Thread.currentThread()) {
      try
      {
        paramHandler = paramCallable.call();
        return paramHandler;
      }
      catch (Exception paramHandler)
      {
        throw new RuntimeException(paramHandler);
      }
    }
    TheadUtils.1Result local1Result = new TheadUtils.1Result();
    TheadUtils.1CaughtException local1CaughtException = new TheadUtils.1CaughtException();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    paramHandler.post(new TheadUtils.3(local1Result, paramCallable, local1CaughtException, localCountDownLatch));
    a(localCountDownLatch);
    if (local1CaughtException.a != null)
    {
      paramHandler = new RuntimeException(local1CaughtException.a);
      paramHandler.setStackTrace(a(local1CaughtException.a.getStackTrace(), paramHandler.getStackTrace()));
      throw paramHandler;
    }
    return local1Result.a;
  }
  
  public static void a(Handler paramHandler, Runnable paramRunnable)
  {
    a(paramHandler, new TheadUtils.4(paramRunnable));
  }
  
  public static void a(TheadUtils.BlockingOperation paramBlockingOperation)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        paramBlockingOperation.a();
        if (i != 0) {
          Thread.currentThread().interrupt();
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        i = 1;
      }
    }
  }
  
  public static void a(CountDownLatch paramCountDownLatch)
  {
    a(new TheadUtils.2(paramCountDownLatch));
  }
  
  static StackTraceElement[] a(StackTraceElement[] paramArrayOfStackTraceElement1, StackTraceElement[] paramArrayOfStackTraceElement2)
  {
    StackTraceElement[] arrayOfStackTraceElement = new StackTraceElement[paramArrayOfStackTraceElement1.length + paramArrayOfStackTraceElement2.length];
    System.arraycopy(paramArrayOfStackTraceElement1, 0, arrayOfStackTraceElement, 0, paramArrayOfStackTraceElement1.length);
    System.arraycopy(paramArrayOfStackTraceElement2, 0, arrayOfStackTraceElement, paramArrayOfStackTraceElement1.length, paramArrayOfStackTraceElement2.length);
    return arrayOfStackTraceElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.util.TheadUtils
 * JD-Core Version:    0.7.0.1
 */