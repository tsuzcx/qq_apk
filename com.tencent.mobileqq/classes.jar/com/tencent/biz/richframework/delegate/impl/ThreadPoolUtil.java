package com.tencent.biz.richframework.delegate.impl;

import android.os.Looper;
import android.os.Process;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtil
{
  public static final int DEFAULT_CORE_NUMS = Runtime.getRuntime().availableProcessors() + 1;
  private static Executor executorService;
  public static int mThreadPoolSize = DEFAULT_CORE_NUMS;
  
  public static void addRunnable(Runnable paramRunnable)
  {
    if (executorService == null) {
      executorService = initDBExecutor();
    }
    executorService.execute(paramRunnable);
  }
  
  private static Executor initDBExecutor()
  {
    Process.setThreadPriority(10);
    int i = mThreadPoolSize;
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(i, i * 2 + 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    if ((localThreadPoolExecutor instanceof ThreadPoolExecutor)) {
      ((ThreadPoolExecutor)localThreadPoolExecutor).setCorePoolSize(3);
    }
    return localThreadPoolExecutor;
  }
  
  public static boolean isOnMainThread()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.delegate.impl.ThreadPoolUtil
 * JD-Core Version:    0.7.0.1
 */