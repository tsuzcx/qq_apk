package com.huawei.hms.adapter;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;

class BaseAdapter$MPendingResultImpl
  extends PendingResultImpl<ResolveResult<CoreBaseResponse>, CoreBaseResponse>
{
  public BaseAdapter$MPendingResultImpl(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
  {
    super(paramApiClient, paramString, paramIMessageEntity);
  }
  
  public ResolveResult<CoreBaseResponse> onComplete(CoreBaseResponse paramCoreBaseResponse)
  {
    paramCoreBaseResponse = new ResolveResult(paramCoreBaseResponse);
    paramCoreBaseResponse.setStatus(Status.SUCCESS);
    return paramCoreBaseResponse;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.adapter.BaseAdapter.MPendingResultImpl
 * JD-Core Version:    0.7.0.1
 */