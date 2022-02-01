package com.huawei.hms.framework.common;

import java.util.concurrent.Delayed;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.TimeUnit;

public class RunnableScheduledFutureEnhance<T>
  implements RunnableScheduledFuture<T>
{
  private String parentName = Thread.currentThread().getName();
  private RunnableScheduledFuture<T> proxy;
  
  public RunnableScheduledFutureEnhance(RunnableScheduledFuture<T> paramRunnableScheduledFuture)
  {
    this.proxy = paramRunnableScheduledFuture;
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    return this.proxy.cancel(paramBoolean);
  }
  
  public int compareTo(Delayed paramDelayed)
  {
    return this.proxy.compareTo(paramDelayed);
  }
  
  public boolean equals(Object paramObject)
  {
    return this.proxy.equals(paramObject);
  }
  
  public T get()
  {
    return this.proxy.get();
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.proxy.get(paramLong, paramTimeUnit);
  }
  
  public long getDelay(TimeUnit paramTimeUnit)
  {
    return this.proxy.getDelay(paramTimeUnit);
  }
  
  public String getParentName()
  {
    return this.parentName;
  }
  
  public int hashCode()
  {
    return this.proxy.hashCode();
  }
  
  public boolean isCancelled()
  {
    return this.proxy.isCancelled();
  }
  
  public boolean isDone()
  {
    return this.proxy.isDone();
  }
  
  public boolean isPeriodic()
  {
    return this.proxy.isPeriodic();
  }
  
  public void run()
  {
    this.proxy.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.RunnableScheduledFutureEnhance
 * JD-Core Version:    0.7.0.1
 */