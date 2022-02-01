package com.tencent.imsdk.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.tencent.imsdk.base.annotations.CalledByNative;
import com.tencent.imsdk.base.annotations.VisibleForTesting;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadUtils
{
  private static final Object sLock = new Object();
  private static boolean sThreadAssertsDisabled;
  private static Handler sUiThreadHandler;
  private static boolean sWillOverride;
  
  public static void assertOnBackgroundThread()
  {
    if (sThreadAssertsDisabled) {}
  }
  
  public static void assertOnUiThread()
  {
    if (sThreadAssertsDisabled) {}
  }
  
  public static void checkUiThread()
  {
    if (!sThreadAssertsDisabled)
    {
      if (runningOnUiThread()) {
        return;
      }
      throw new IllegalStateException("Must be called on the UI thread.");
    }
  }
  
  public static Handler getUiThreadHandler()
  {
    synchronized (sLock)
    {
      if (sUiThreadHandler == null) {
        if (!sWillOverride) {
          sUiThreadHandler = new Handler(Looper.getMainLooper());
        } else {
          throw new RuntimeException("Did not yet override the UI thread");
        }
      }
      Handler localHandler = sUiThreadHandler;
      return localHandler;
    }
  }
  
  public static Looper getUiThreadLooper()
  {
    return getUiThreadHandler().getLooper();
  }
  
  @CalledByNative
  private static boolean isThreadPriorityAudio(int paramInt)
  {
    return Process.getThreadPriority(paramInt) == -16;
  }
  
  @Deprecated
  public static <T> FutureTask<T> postOnUiThread(FutureTask<T> paramFutureTask)
  {
    getUiThreadHandler().post(paramFutureTask);
    return paramFutureTask;
  }
  
  @Deprecated
  public static void postOnUiThread(Runnable paramRunnable)
  {
    getUiThreadHandler().post(paramRunnable);
  }
  
  @Deprecated
  @VisibleForTesting
  public static void postOnUiThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    getUiThreadHandler().postDelayed(paramRunnable, paramLong);
  }
  
  @Deprecated
  public static <T> FutureTask<T> runOnUiThread(Callable<T> paramCallable)
  {
    return runOnUiThread(new FutureTask(paramCallable));
  }
  
  @Deprecated
  public static <T> FutureTask<T> runOnUiThread(FutureTask<T> paramFutureTask)
  {
    if (runningOnUiThread())
    {
      paramFutureTask.run();
      return paramFutureTask;
    }
    postOnUiThread(paramFutureTask);
    return paramFutureTask;
  }
  
  @Deprecated
  public static void runOnUiThread(Runnable paramRunnable)
  {
    if (runningOnUiThread())
    {
      paramRunnable.run();
      return;
    }
    getUiThreadHandler().post(paramRunnable);
  }
  
  @Deprecated
  public static <T> T runOnUiThreadBlocking(Callable<T> paramCallable)
  {
    paramCallable = new FutureTask(paramCallable);
    runOnUiThread(paramCallable);
    try
    {
      paramCallable = paramCallable.get();
      return paramCallable;
    }
    catch (InterruptedException paramCallable)
    {
      throw new RuntimeException("Interrupted waiting for callable", paramCallable);
    }
  }
  
  @Deprecated
  public static void runOnUiThreadBlocking(Runnable paramRunnable)
  {
    if (runningOnUiThread())
    {
      paramRunnable.run();
      return;
    }
    paramRunnable = new FutureTask(paramRunnable, null);
    postOnUiThread(paramRunnable);
    try
    {
      paramRunnable.get();
      return;
    }
    catch (Exception paramRunnable)
    {
      throw new RuntimeException("Exception occurred while waiting for runnable", paramRunnable);
    }
  }
  
  @Deprecated
  @VisibleForTesting
  public static <T> T runOnUiThreadBlockingNoException(Callable<T> paramCallable)
  {
    try
    {
      paramCallable = runOnUiThreadBlocking(paramCallable);
      return paramCallable;
    }
    catch (ExecutionException paramCallable)
    {
      throw new RuntimeException("Error occurred waiting for callable", paramCallable);
    }
  }
  
  public static boolean runningOnUiThread()
  {
    return getUiThreadHandler().getLooper() == Looper.myLooper();
  }
  
  public static void setThreadAssertsDisabledForTesting(boolean paramBoolean)
  {
    sThreadAssertsDisabled = paramBoolean;
  }
  
  @CalledByNative
  public static void setThreadPriorityAudio(int paramInt)
  {
    Process.setThreadPriority(paramInt, -16);
  }
  
  public static void setUiThread(Looper paramLooper)
  {
    localObject = sLock;
    if (paramLooper == null) {}
    try
    {
      sUiThreadHandler = null;
      return;
    }
    finally {}
    if ((sUiThreadHandler != null) && (sUiThreadHandler.getLooper() != paramLooper))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UI thread looper is already set to ");
      localStringBuilder.append(sUiThreadHandler.getLooper());
      localStringBuilder.append(" (Main thread looper is ");
      localStringBuilder.append(Looper.getMainLooper());
      localStringBuilder.append("), cannot set to new looper ");
      localStringBuilder.append(paramLooper);
      throw new RuntimeException(localStringBuilder.toString());
    }
    sUiThreadHandler = new Handler(paramLooper);
  }
  
  public static void setWillOverrideUiThread(boolean paramBoolean)
  {
    synchronized (sLock)
    {
      sWillOverride = paramBoolean;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.base.ThreadUtils
 * JD-Core Version:    0.7.0.1
 */