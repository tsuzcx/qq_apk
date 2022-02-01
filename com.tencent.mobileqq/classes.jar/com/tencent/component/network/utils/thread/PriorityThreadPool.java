package com.tencent.component.network.utils.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityThreadPool
  extends ThreadPool
{
  public PriorityThreadPool()
  {
    this("priority-thread-pool", DEFAULT_POOL_SIZE);
  }
  
  public PriorityThreadPool(String paramString, int paramInt)
  {
    super(paramString, paramInt, paramInt, new PriorityBlockingQueue());
  }
  
  public PriorityThreadPool(Executor paramExecutor)
  {
    super(paramExecutor);
  }
  
  public static PriorityThreadPool getDefault()
  {
    return PriorityThreadPool.InstanceHolder.INSTANCE;
  }
  
  public <T> Future<T> submit(ThreadPool.Job<T> paramJob)
  {
    return submit(paramJob, null, null);
  }
  
  public <T> Future<T> submit(ThreadPool.Job<T> paramJob, FutureListener<T> paramFutureListener)
  {
    return submit(paramJob, paramFutureListener, null);
  }
  
  public <T> Future<T> submit(ThreadPool.Job<T> paramJob, FutureListener<T> paramFutureListener, PriorityThreadPool.Priority paramPriority)
  {
    PriorityThreadPool.Priority localPriority = paramPriority;
    if (paramPriority == null) {
      localPriority = PriorityThreadPool.Priority.NORMAL;
    }
    return super.submit(new PriorityThreadPool.PriorityJob(paramJob, localPriority.priority, localPriority.fifo), paramFutureListener);
  }
  
  public <T> Future<T> submit(ThreadPool.Job<T> paramJob, PriorityThreadPool.Priority paramPriority)
  {
    return submit(paramJob, null, paramPriority);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.PriorityThreadPool
 * JD-Core Version:    0.7.0.1
 */