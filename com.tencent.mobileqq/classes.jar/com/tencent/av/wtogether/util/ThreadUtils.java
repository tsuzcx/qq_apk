package com.tencent.av.wtogether.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class ThreadUtils
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
    ThreadUtils.1Result local1Result = new ThreadUtils.1Result();
    ThreadUtils.1CaughtException local1CaughtException = new ThreadUtils.1CaughtException();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    paramHandler.post(new ThreadUtils.3(local1Result, paramCallable, local1CaughtException, localCountDownLatch));
    a(localCountDownLatch);
    if (local1CaughtException.a == null) {
      return local1Result.a;
    }
    paramHandler = new RuntimeException(local1CaughtException.a);
    paramHandler.setStackTrace(a(local1CaughtException.a.getStackTrace(), paramHandler.getStackTrace()));
    throw paramHandler;
  }
  
  public static void a(Handler paramHandler, Runnable paramRunnable)
  {
    a(paramHandler, new ThreadUtils.4(paramRunnable));
  }
  
  public static void a(ThreadUtils.BlockingOperation paramBlockingOperation)
  {
    for (int i = 0;; i = 1) {
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
        label19:
        break label19;
      }
    }
  }
  
  public static void a(CountDownLatch paramCountDownLatch)
  {
    a(new ThreadUtils.2(paramCountDownLatch));
  }
  
  static StackTraceElement[] a(StackTraceElement[] paramArrayOfStackTraceElement1, StackTraceElement[] paramArrayOfStackTraceElement2)
  {
    StackTraceElement[] arrayOfStackTraceElement = new StackTraceElement[paramArrayOfStackTraceElement1.length + paramArrayOfStackTraceElement2.length];
    System.arraycopy(paramArrayOfStackTraceElement1, 0, arrayOfStackTraceElement, 0, paramArrayOfStackTraceElement1.length);
    System.arraycopy(paramArrayOfStackTraceElement2, 0, arrayOfStackTraceElement, paramArrayOfStackTraceElement1.length, paramArrayOfStackTraceElement2.length);
    return arrayOfStackTraceElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.util.ThreadUtils
 * JD-Core Version:    0.7.0.1
 */