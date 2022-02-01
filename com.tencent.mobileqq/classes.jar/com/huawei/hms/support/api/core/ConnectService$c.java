package com.huawei.hms.support.api.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.JosBaseResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;

final class ConnectService$c
  extends PendingResultImpl<ResolveResult<JosGetNoticeResp>, JosGetNoticeResp>
{
  ConnectService$c(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("josNoticeResp status code :");
    localStringBuilder.append(paramJosGetNoticeResp.getStatusCode());
    HMSLog.i("connectservice", localStringBuilder.toString());
    paramJosGetNoticeResp = new ResolveResult(paramJosGetNoticeResp);
    paramJosGetNoticeResp.setStatus(Status.SUCCESS);
    return paramJosGetNoticeResp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.api.core.ConnectService.c
 * JD-Core Version:    0.7.0.1
 */