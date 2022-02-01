package com.peterlmeng.animate_image;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadManager
{
  protected static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
  public static final int TYPE_DRAWABLE_INIT = 2;
  public static final int TYPE_MAIN = 3;
  public static final int TYPE_RESOURCE_LOAD = 1;
  protected static final int maximumPoolSize = CPU_COUNT * 3 + 1;
  private static volatile ThreadManager sInstance;
  private ThreadPoolExecutor drawableExecutor;
  Handler mainHandler;
  private ThreadPoolExecutor resourceExecutor;
  
  private ThreadManager()
  {
    initThreadPool();
    this.mainHandler = new Handler(Looper.getMainLooper());
  }
  
  public static ThreadManager getsInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new ThreadManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private void initThreadPool()
  {
    if (this.resourceExecutor == null) {
      this.resourceExecutor = new ThreadPoolExecutor(10, ThreadManager.ResourcePoolConfig.a(), 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(128));
    }
    if (this.drawableExecutor == null) {
      this.drawableExecutor = new ThreadPoolExecutor(10, ThreadManager.ResourcePoolConfig.a(), 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(128));
    }
  }
  
  public void execute(int paramInt, Runnable paramRunnable)
  {
    ThreadPoolExecutor localThreadPoolExecutor;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3)
        {
          this.mainHandler.post(paramRunnable);
          return;
        }
        throw new RuntimeException(" You should complete other types!");
      }
      localThreadPoolExecutor = this.drawableExecutor;
    }
    else
    {
      localThreadPoolExecutor = this.resourceExecutor;
    }
    localThreadPoolExecutor.execute(paramRunnable);
  }
  
  public void removeTask(Runnable paramRunnable, int paramInt)
  {
    ThreadPoolExecutor localThreadPoolExecutor;
    if (paramInt != 1)
    {
      if (paramInt == 2) {
        localThreadPoolExecutor = this.drawableExecutor;
      } else {
        throw new RuntimeException(" You should complete other types!");
      }
    }
    else {
      localThreadPoolExecutor = this.resourceExecutor;
    }
    localThreadPoolExecutor.remove(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.peterlmeng.animate_image.ThreadManager
 * JD-Core Version:    0.7.0.1
 */