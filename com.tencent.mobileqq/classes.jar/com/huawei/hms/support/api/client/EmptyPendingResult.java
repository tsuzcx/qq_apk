package com.huawei.hms.support.api.client;

import android.os.Looper;
import java.util.concurrent.TimeUnit;

public class EmptyPendingResult<R extends Result>
  extends PendingResult<R>
{
  private R a;
  
  public R await()
  {
    return this.a;
  }
  
  public R await(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.a;
  }
  
  public void cancel() {}
  
  public R getResult()
  {
    return this.a;
  }
  
  public boolean isCanceled()
  {
    return false;
  }
  
  public void setResult(R paramR)
  {
    this.a = paramR;
  }
  
  public void setResultCallback(Looper paramLooper, ResultCallback<R> paramResultCallback) {}
  
  public void setResultCallback(ResultCallback<R> paramResultCallback) {}
  
  public void setResultCallback(ResultCallback<R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.support.api.client.EmptyPendingResult
 * JD-Core Version:    0.7.0.1
 */