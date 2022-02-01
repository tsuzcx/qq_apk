package com.huawei.hms.support.api.client;

import com.huawei.hms.common.api.Releasable;
import com.huawei.hms.support.log.HMSLog;

@Deprecated
public abstract class ResultCallbacks<R extends Result>
  implements ResultCallback<R>
{
  public abstract void onFailure(Status paramStatus);
  
  public final void onResult(R paramR)
  {
    try
    {
      Status localStatus = paramR.getStatus();
      if (localStatus.isSuccess())
      {
        onSuccess(paramR);
        return;
      }
      onFailure(localStatus);
      if ((paramR instanceof Releasable))
      {
        ((Releasable)paramR).release();
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to release ");
      localStringBuilder.append(paramR);
      localStringBuilder.append(", reason: ");
      localStringBuilder.append(localException);
      HMSLog.w("ResultCallbacks", localStringBuilder.toString());
    }
  }
  
  public abstract void onSuccess(R paramR);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.api.client.ResultCallbacks
 * JD-Core Version:    0.7.0.1
 */