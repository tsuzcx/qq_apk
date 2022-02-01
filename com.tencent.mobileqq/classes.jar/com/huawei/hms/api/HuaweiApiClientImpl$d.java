package com.huawei.hms.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.Status;

class HuaweiApiClientImpl$d
  extends PendingResultImpl<Status, IMessageEntity>
{
  public HuaweiApiClientImpl$d(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
  {
    super(paramApiClient, paramString, paramIMessageEntity);
  }
  
  public Status a(IMessageEntity paramIMessageEntity)
  {
    return new Status(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.api.HuaweiApiClientImpl.d
 * JD-Core Version:    0.7.0.1
 */