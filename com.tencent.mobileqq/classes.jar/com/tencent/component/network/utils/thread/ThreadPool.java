package com.tencent.component.network.utils.thread;

import com.tencent.component.network.downloader.impl.DownloaderImpl;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool
{
  protected static final int DEFAULT_POOL_SIZE = DownloaderImpl.THREAD_POOL_SIZE;
  public static final ThreadPool.JobContext JOB_CONTEXT_STUB = new ThreadPool.JobContextStub(null);
  protected static final int KEEP_ALIVE_TIME = 10;
  public static final int MODE_CPU = 1;
  public static final int MODE_NETWORK = 2;
  public static final int MODE_NONE = 0;
  private static final String TAG = "ThreadPool";
  ThreadPool.ResourceCounter mCpuCounter = new ThreadPool.ResourceCounter(2);
  private final Executor mExecutor;
  ThreadPool.ResourceCounter mNetworkCounter = new ThreadPool.ResourceCounter(DownloaderImpl.THREAD_POOL_SIZE);
  
  public ThreadPool()
  {
    this("thread-pool", DEFAULT_POOL_SIZE);
  }
  
  public ThreadPool(String paramString, int paramInt)
  {
    this(paramString, paramInt, paramInt, new LinkedBlockingQueue());
  }
  
  public ThreadPool(String paramString, int paramInt1, int paramInt2, BlockingQueue<Runnable> paramBlockingQueue)
  {
    if (paramInt1 <= 0) {
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt2 <= paramInt1) {
        paramInt2 = paramInt1;
      }
      for (;;)
      {
        this.mNetworkCounter.value = paramInt2;
        this.mExecutor = new SmartThreadExecutor(new ThreadPoolExecutor(paramInt1, paramInt2, 10L, TimeUnit.SECONDS, paramBlockingQueue, new PriorityThreadFactory(paramString, 10)));
        return;
      }
    }
  }
  
  public ThreadPool(Executor paramExecutor)
  {
    if (paramExecutor != null) {}
    for (;;)
    {
      this.mExecutor = new SmartThreadExecutor(paramExecutor);
      return;
      paramExecutor = new ThreadPoolExecutor(2, 2, 10L, TimeUnit.SECONDS, new PriorityBlockingQueue(), new PriorityThreadFactory("thread_pool", 10));
    }
  }
  
  public <T> Future<T> submit(ThreadPool.Job<T> paramJob)
  {
    return submit(paramJob, null);
  }
  
  public <T> Future<T> submit(ThreadPool.Job<T> paramJob, FutureListener<T> paramFutureListener)
  {
    paramJob = new ThreadPool.Worker(this, paramJob, paramFutureListener);
    this.mExecutor.execute(paramJob);
    return paramJob;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.ThreadPool
 * JD-Core Version:    0.7.0.1
 */