package com.huawei.hms.common.internal;

import com.huawei.hms.api.HuaweiApiClient;

class AutoLifecycleFragment$ClientInfo
{
  public final HuaweiApiClient apiClient;
  public final int clientId;
  
  public AutoLifecycleFragment$ClientInfo(AutoLifecycleFragment paramAutoLifecycleFragment, int paramInt, HuaweiApiClient paramHuaweiApiClient)
  {
    this.apiClient = paramHuaweiApiClient;
    this.clientId = paramInt;
  }
  
  public void stopAutoManage()
  {
    this.apiClient.disconnect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.AutoLifecycleFragment.ClientInfo
 * JD-Core Version:    0.7.0.1
 */