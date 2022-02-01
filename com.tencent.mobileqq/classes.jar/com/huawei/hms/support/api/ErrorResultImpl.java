package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.log.HMSLog;
import java.util.concurrent.TimeUnit;

public abstract class ErrorResultImpl<R extends Result>
  extends PendingResult<R>
{
  private R a = null;
  private int b;
  
  public ErrorResultImpl(int paramInt)
  {
    this.b = paramInt;
  }
  
  private R a(int paramInt)
  {
    Object localObject = ErrorResultImpl.class.getGenericSuperclass();
    if (localObject != null) {
      localObject = GenericTypeReflector.getType(((java.lang.reflect.ParameterizedType)localObject).getActualTypeArguments()[0]);
    }
    try
    {
      this.a = ((Result)((Class)localObject).newInstance());
      this.a.setStatus(new Status(paramInt));
    }
    catch (InstantiationException localInstantiationException)
    {
      break label64;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      label54:
      break label54;
    }
    HMSLog.e("ErrorResultImpl", "IllegalAccessException");
    break label71;
    label64:
    HMSLog.e("ErrorResultImpl", "InstantiationException");
    label71:
    return this.a;
    return null;
  }
  
  public final R await()
  {
    return await(0L, null);
  }
  
  public R await(long paramLong, TimeUnit paramTimeUnit)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      return a(this.b);
    }
    throw new IllegalStateException("await must not be called on the UI thread");
  }
  
  @Deprecated
  public void cancel() {}
  
  @Deprecated
  public boolean isCanceled()
  {
    return false;
  }
  
  public final void setResultCallback(Looper paramLooper, ResultCallback<R> paramResultCallback)
  {
    Looper localLooper = paramLooper;
    if (paramLooper == null) {
      localLooper = Looper.myLooper();
    }
    new Handler(localLooper).post(new ErrorResultImpl.a(this, paramResultCallback));
  }
  
  public final void setResultCallback(ResultCallback<R> paramResultCallback)
  {
    setResultCallback(Looper.getMainLooper(), paramResultCallback);
  }
  
  @Deprecated
  public void setResultCallback(ResultCallback<R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    setResultCallback(paramResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.api.ErrorResultImpl
 * JD-Core Version:    0.7.0.1
 */