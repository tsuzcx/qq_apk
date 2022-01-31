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
  ThreadPool.ResourceCounter jdField_a_of_type_ComTencentComponentNetworkUtilsThreadThreadPool$ResourceCounter = new ThreadPool.ResourceCounter(2);
  private final Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  ThreadPool.ResourceCounter b = new ThreadPool.ResourceCounter(DownloaderImpl.THREAD_POOL_SIZE);
  
  public ThreadPool()
  {
    this("thread-pool", DEFAULT_POOL_SIZE);
  }
  
  public ThreadPool(String paramString, int paramInt)
  {
    this(paramString, paramInt, paramInt, new LinkedBlockingQueue());
  }
  
  public ThreadPool(String paramString, int paramInt1, int paramInt2, BlockingQueue paramBlockingQueue)
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
        this.b.value = paramInt2;
        this.jdField_a_of_type_JavaUtilConcurrentExecutor = new ThreadPoolExecutor(paramInt1, paramInt2, 10L, TimeUnit.SECONDS, paramBlockingQueue, new PriorityThreadFactory(paramString, 10));
        return;
      }
    }
  }
  
  public ThreadPool(Executor paramExecutor)
  {
    if (paramExecutor != null) {}
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentExecutor = paramExecutor;
      return;
      paramExecutor = new ThreadPoolExecutor(2, 2, 10L, TimeUnit.SECONDS, new PriorityBlockingQueue(), new PriorityThreadFactory("thread_pool", 10));
    }
  }
  
  public Future submit(ThreadPool.Job paramJob)
  {
    return submit(paramJob, null);
  }
  
  public Future submit(ThreadPool.Job paramJob, FutureListener paramFutureListener)
  {
    paramJob = new ThreadPool.Worker(this, paramJob, paramFutureListener);
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(paramJob);
    return paramJob;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.ThreadPool
 * JD-Core Version:    0.7.0.1
 */