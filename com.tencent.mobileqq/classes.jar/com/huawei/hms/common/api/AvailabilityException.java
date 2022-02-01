package com.huawei.hms.common.api;

import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.support.log.HMSLog;

public class AvailabilityException
  extends Exception
{
  private String a = "AvailabilityException";
  private String b = null;
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.b = "INTERNAL_ERROR";
      return;
    case 0: 
      this.b = "success";
      return;
    case 21: 
      this.b = "ANDROID_VERSION_UNSUPPORT";
      return;
    case 1: 
      this.b = "SERVICE_MISSING";
      return;
    case 3: 
      this.b = "SERVICE_DISABLED";
      return;
    }
    this.b = "SERVICE_VERSION_UPDATE_REQUIRED";
  }
  
  private ConnectionResult b(int paramInt)
  {
    HMSLog.i(this.a, "The availability check result is: " + paramInt);
    a(paramInt);
    return new ConnectionResult(paramInt);
  }
  
  public ConnectionResult getConnectionResult(HuaweiApi<? extends Api.ApiOptions> paramHuaweiApi)
  {
    if (paramHuaweiApi == null)
    {
      HMSLog.e(this.a, "The huaweiApi is null.");
      return b(8);
    }
    paramHuaweiApi = paramHuaweiApi.getContext();
    return b(HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(paramHuaweiApi, 30000000));
  }
  
  public ConnectionResult getConnectionResult(HuaweiApiCallable paramHuaweiApiCallable)
  {
    if ((paramHuaweiApiCallable == null) || (paramHuaweiApiCallable.getHuaweiApi() == null))
    {
      HMSLog.e(this.a, "The huaweiApi is null.");
      return b(8);
    }
    paramHuaweiApiCallable = paramHuaweiApiCallable.getHuaweiApi().getContext();
    return b(HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(paramHuaweiApiCallable, 30000000));
  }
  
  public String getMessage()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.api.AvailabilityException
 * JD-Core Version:    0.7.0.1
 */