package com.huawei.hms.push;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class u
{
  public static final Object a = new Object();
  public static ThreadPoolExecutor b = new ThreadPoolExecutor(1, 50, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  
  public static ThreadPoolExecutor a()
  {
    synchronized (a)
    {
      ThreadPoolExecutor localThreadPoolExecutor = b;
      return localThreadPoolExecutor;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.push.u
 * JD-Core Version:    0.7.0.1
 */