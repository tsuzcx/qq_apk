package com.huawei.hmf.tasks.a;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a
{
  static final int a;
  static final int b = e * 2 + 1;
  private static final a c = new a();
  private static final int e;
  private final Executor d = new a.a((byte)0);
  
  static
  {
    int i = Runtime.getRuntime().availableProcessors();
    e = i;
    a = i + 1;
  }
  
  public static ExecutorService a()
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(a, b, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    localThreadPoolExecutor.allowCoreThreadTimeOut(true);
    return localThreadPoolExecutor;
  }
  
  public static Executor b()
  {
    return c.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hmf.tasks.a.a
 * JD-Core Version:    0.7.0.1
 */