package com.huawei.hms.support.api.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;

final class ConnectService$3
  extends PendingResultImpl<ResolveResult<JosGetNoticeResp>, JosGetNoticeResp>
{
  ConnectService$3(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
  {
    super(paramApiClient, paramString, paramIMessageEntity);
  }
  
  public ResolveResult<JosGetNoticeResp> a(JosGetNoticeResp paramJosGetNoticeResp)
  {
    if (paramJosGetNoticeResp == null)
    {
      HMSLog.e("connectservice", "JosNoticeResp is null");
      return null;
    }
    HMSLog.i("connectservice", "josNoticeResp status code :" + paramJosGetNoticeResp.getStatusCode());
    paramJosGetNoticeResp = new ResolveResult(paramJosGetNoticeResp);
    paramJosGetNoticeResp.setStatus(Status.SUCCESS);
    return paramJosGetNoticeResp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.api.core.ConnectService.3
 * JD-Core Version:    0.7.0.1
 */