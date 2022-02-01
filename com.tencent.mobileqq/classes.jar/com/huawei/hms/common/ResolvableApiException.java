package com.huawei.hms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;

public class ResolvableApiException
  extends ApiException
{
  public ResolvableApiException(ResponseErrorCode paramResponseErrorCode)
  {
    super(new Status(paramResponseErrorCode.getErrorCode(), paramResponseErrorCode.getErrorReason()));
    if (paramResponseErrorCode.hasResolution())
    {
      if ((paramResponseErrorCode.getParcelable() instanceof PendingIntent))
      {
        this.mStatus.setPendingIntent((PendingIntent)paramResponseErrorCode.getParcelable());
        return;
      }
      if ((paramResponseErrorCode.getParcelable() instanceof Intent)) {
        this.mStatus.setIntent((Intent)paramResponseErrorCode.getParcelable());
      }
    }
  }
  
  public ResolvableApiException(Status paramStatus)
  {
    super(paramStatus);
  }
  
  public PendingIntent getResolution()
  {
    return this.mStatus.getResolution();
  }
  
  public Intent getResolutionIntent()
  {
    return this.mStatus.getResolutionIntent();
  }
  
  public void startResolutionForResult(Activity paramActivity, int paramInt)
  {
    this.mStatus.startResolutionForResult(paramActivity, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.ResolvableApiException
 * JD-Core Version:    0.7.0.1
 */