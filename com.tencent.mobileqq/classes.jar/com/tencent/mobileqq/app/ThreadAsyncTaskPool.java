package com.tencent.mobileqq.app;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;

class ThreadAsyncTaskPool
  extends ThreadSmartPool
{
  private static final int BLOCKING_QUEUE_SIZE = 128;
  private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
  private static final int KEEP_ALIVE_TIME = 2;
  private static final int MAX_POOL_SIZE = CPU_COUNT * 2 + 1;
  
  private ThreadAsyncTaskPool(BlockingQueue<Runnable> paramBlockingQueue, PriorityThreadFactory paramPriorityThreadFactory)
  {
    super(CORE_POOL_SIZE, MAX_POOL_SIZE, 2L, paramBlockingQueue, paramPriorityThreadFactory);
  }
  
  public static ThreadSmartPool createThreadPool()
  {
    return new ThreadAsyncTaskPool(new LinkedBlockingDeque(128), new PriorityThreadFactory("thread_sp_Async_", 5));
  }
  
  protected String getName()
  {
    return "ThreadAsyncTaskPool";
  }
  
  protected ConcurrentLinkedQueue<String> getRunningJobCache()
  {
    return Job.runningJmapInAync;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadAsyncTaskPool
 * JD-Core Version:    0.7.0.1
 */