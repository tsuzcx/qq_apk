package com.huawei.hms.support.api.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.log.HMSLog;

final class ConnectService$b
  extends PendingResultImpl<ResolveResult<ConnectResp>, ConnectResp>
{
  ConnectService$b(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
  {
    super(paramApiClient, paramString, paramIMessageEntity);
  }
  
  public ResolveResult<ConnectResp> a(ConnectResp paramConnectResp)
  {
    paramConnectResp = new ResolveResult(paramConnectResp);
    paramConnectResp.setStatus(Status.SUCCESS);
    HMSLog.d("connectservice", "forceConnect - onComplete: success");
    return paramConnectResp;
  }
  
  protected boolean checkApiClient(ApiClient paramApiClient)
  {
    return paramApiClient != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.api.core.ConnectService.b
 * JD-Core Version:    0.7.0.1
 */