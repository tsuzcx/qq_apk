package com.huawei.hms.common.api;

import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.support.log.HMSLog;

public class AvailabilityException
  extends Exception
{
  private String TAG = "AvailabilityException";
  private String message = null;
  
  private ConnectionResult generateConnectionResult(int paramInt)
  {
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("The availability check result is: ");
    localStringBuilder.append(paramInt);
    HMSLog.i(str, localStringBuilder.toString());
    setMessage(paramInt);
    return new ConnectionResult(paramInt);
  }
  
  private void setMessage(int paramInt)
  {
    if (paramInt != 21)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              this.message = "INTERNAL_ERROR";
              return;
            }
            this.message = "SERVICE_DISABLED";
            return;
          }
          this.message = "SERVICE_VERSION_UPDATE_REQUIRED";
          return;
        }
        this.message = "SERVICE_MISSING";
        return;
      }
      this.message = "success";
      return;
    }
    this.message = "ANDROID_VERSION_UNSUPPORT";
  }
  
  public ConnectionResult getConnectionResult(HuaweiApi<? extends Api.ApiOptions> paramHuaweiApi)
  {
    if (paramHuaweiApi == null)
    {
      HMSLog.e(this.TAG, "The huaweiApi is null.");
      return generateConnectionResult(8);
    }
    paramHuaweiApi = paramHuaweiApi.getContext();
    return generateConnectionResult(HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(paramHuaweiApi, 30000000));
  }
  
  public ConnectionResult getConnectionResult(HuaweiApiCallable paramHuaweiApiCallable)
  {
    if ((paramHuaweiApiCallable != null) && (paramHuaweiApiCallable.getHuaweiApi() != null))
    {
      paramHuaweiApiCallable = paramHuaweiApiCallable.getHuaweiApi().getContext();
      return generateConnectionResult(HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(paramHuaweiApiCallable, 30000000));
    }
    HMSLog.e(this.TAG, "The huaweiApi is null.");
    return generateConnectionResult(8);
  }
  
  public String getMessage()
  {
    return this.message;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.api.AvailabilityException
 * JD-Core Version:    0.7.0.1
 */