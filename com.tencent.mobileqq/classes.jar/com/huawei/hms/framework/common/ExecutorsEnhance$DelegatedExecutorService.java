package com.huawei.hms.framework.common;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class ExecutorsEnhance$DelegatedExecutorService
  extends AbstractExecutorService
{
  private final ExecutorService e;
  
  ExecutorsEnhance$DelegatedExecutorService(ExecutorService paramExecutorService)
  {
    this.e = paramExecutorService;
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.e.awaitTermination(paramLong, paramTimeUnit);
  }
  
  public void execute(Runnable paramRunnable)
  {
    this.e.execute(paramRunnable);
  }
  
  public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection)
  {
    return this.e.invokeAll(paramCollection);
  }
  
  public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit)
  {
    return this.e.invokeAll(paramCollection, paramLong, paramTimeUnit);
  }
  
  public <T> T invokeAny(Collection<? extends Callable<T>> paramCollection)
  {
    return this.e.invokeAny(paramCollection);
  }
  
  public <T> T invokeAny(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit)
  {
    return this.e.invokeAny(paramCollection, paramLong, paramTimeUnit);
  }
  
  public boolean isShutdown()
  {
    return this.e.isShutdown();
  }
  
  public boolean isTerminated()
  {
    return this.e.isTerminated();
  }
  
  public void shutdown()
  {
    this.e.shutdown();
  }
  
  public List<Runnable> shutdownNow()
  {
    return this.e.shutdownNow();
  }
  
  public Future<?> submit(Runnable paramRunnable)
  {
    return this.e.submit(paramRunnable);
  }
  
  public <T> Future<T> submit(Runnable paramRunnable, T paramT)
  {
    return this.e.submit(paramRunnable, paramT);
  }
  
  public <T> Future<T> submit(Callable<T> paramCallable)
  {
    return this.e.submit(paramCallable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.ExecutorsEnhance.DelegatedExecutorService
 * JD-Core Version:    0.7.0.1
 */