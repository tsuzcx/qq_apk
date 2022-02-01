package com.huawei.hms.common.api.internal;

import android.os.Looper;
import com.huawei.hms.common.api.OptionalPendingResult;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import java.util.concurrent.TimeUnit;

@Deprecated
public final class OptionalPendingResultImpl<R extends Result>
  extends OptionalPendingResult<R>
{
  private final PendingResult<R> pendingResult;
  
  public OptionalPendingResultImpl(PendingResult<R> paramPendingResult)
  {
    this.pendingResult = paramPendingResult;
  }
  
  public final void addStatusListener() {}
  
  public final R await()
  {
    return this.pendingResult.await();
  }
  
  public final R await(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.pendingResult.await(paramLong, paramTimeUnit);
  }
  
  public final void cancel() {}
  
  public final R get()
  {
    throw new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
  }
  
  public final boolean isCanceled()
  {
    return false;
  }
  
  public final boolean isDone()
  {
    return false;
  }
  
  public void setResultCallback(Looper paramLooper, ResultCallback<R> paramResultCallback)
  {
    this.pendingResult.setResultCallback(paramLooper, paramResultCallback);
  }
  
  public final void setResultCallback(ResultCallback<R> paramResultCallback)
  {
    this.pendingResult.setResultCallback(paramResultCallback);
  }
  
  public final void setResultCallback(ResultCallback<R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    setResultCallback(paramResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.api.internal.OptionalPendingResultImpl
 * JD-Core Version:    0.7.0.1
 */