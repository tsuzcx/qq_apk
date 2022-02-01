package com.tencent.mobileqq.app;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ThreadAioDownloadPool
  extends ThreadSmartPool
{
  private static final int BLOCKING_QUEUE_SIZE = 64;
  private static final int CORE_POOL_SIZE = 3;
  private static final int KEEP_ALIVE_TIME = 2;
  private static final int MAX_POOL_SIZE = Math.max(3, maximumPoolSize);
  
  private ThreadAioDownloadPool(BlockingQueue<Runnable> paramBlockingQueue, PriorityThreadFactory paramPriorityThreadFactory)
  {
    super(3, MAX_POOL_SIZE, 2L, paramBlockingQueue, paramPriorityThreadFactory);
  }
  
  public static ThreadSmartPool createThreadPool()
  {
    return new ThreadAioDownloadPool(new LinkedBlockingQueue(64), new PriorityThreadFactory("thread_AioDownload_", 2));
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    super.beforeExecute(paramThread, paramRunnable);
  }
  
  protected String getName()
  {
    return "ThreadAioDownloadPool";
  }
  
  protected ConcurrentLinkedQueue<String> getRunningJobCache()
  {
    return Job.runningJmapInDownload;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadAioDownloadPool
 * JD-Core Version:    0.7.0.1
 */