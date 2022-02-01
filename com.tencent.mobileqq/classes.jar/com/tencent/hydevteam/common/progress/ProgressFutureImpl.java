package com.tencent.hydevteam.common.progress;

import com.tencent.hydevteam.common.annotation.API;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@API
public class ProgressFutureImpl<T>
  implements ProgressFuture<T>
{
  private Future<T> a;
  private Progress b;
  
  public ProgressFutureImpl(Future<T> paramFuture, Progress paramProgress)
  {
    this.a = paramFuture;
    this.b = paramProgress;
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    return this.a.cancel(paramBoolean);
  }
  
  public T get()
  {
    return this.a.get();
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.a.get(paramLong, paramTimeUnit);
  }
  
  public double getProgress()
  {
    Progress localProgress = this.b;
    if (localProgress == null) {
      return 0.0D;
    }
    return localProgress.getProgress();
  }
  
  public boolean isCancelled()
  {
    return this.a.isCancelled();
  }
  
  public boolean isDone()
  {
    return this.a.isDone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hydevteam.common.progress.ProgressFutureImpl
 * JD-Core Version:    0.7.0.1
 */