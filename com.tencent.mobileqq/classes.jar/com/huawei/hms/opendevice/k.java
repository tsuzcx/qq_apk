package com.huawei.hms.opendevice;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.DeleteTokenResp;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

public class k
  extends TaskApiCall<PushClient, Void>
{
  public DeleteTokenReq a;
  
  public k(String paramString1, DeleteTokenReq paramDeleteTokenReq, String paramString2)
  {
    super(paramString1, JsonUtil.createJsonString(paramDeleteTokenReq), paramString2);
    this.a = paramDeleteTokenReq;
  }
  
  public void a(PushClient paramPushClient, ResponseErrorCode paramResponseErrorCode, String paramString, TaskCompletionSource<Void> paramTaskCompletionSource)
  {
    if (paramResponseErrorCode.getErrorCode() != 0)
    {
      paramPushClient = HmsInstanceId.TAG;
      paramString = new StringBuilder();
      paramString.append("DeleteTokenTask failed, ErrorCode: ");
      paramString.append(paramResponseErrorCode.getErrorCode());
      HMSLog.e(paramPushClient, paramString.toString());
      paramPushClient = ErrorEnum.fromCode(paramResponseErrorCode.getErrorCode());
      if (paramPushClient != ErrorEnum.ERROR_UNKNOWN)
      {
        paramTaskCompletionSource.setException(paramPushClient.toApiException());
        return;
      }
      paramTaskCompletionSource.setException(new ApiException(new Status(paramResponseErrorCode.getErrorCode(), paramResponseErrorCode.getErrorReason())));
      return;
    }
    paramString = ErrorEnum.fromCode(((DeleteTokenResp)JsonUtil.jsonToEntity(paramString, new DeleteTokenResp())).getRetCode());
    if (paramString != ErrorEnum.SUCCESS)
    {
      paramTaskCompletionSource.setException(paramString.toApiException());
      return;
    }
    paramTaskCompletionSource.setResult(null);
    q.a(paramPushClient.getContext(), getUri(), paramResponseErrorCode);
  }
  
  public int getMinApkVersion()
  {
    if (this.a.isMultiSender()) {
      return 50004300;
    }
    return 30000000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.opendevice.k
 * JD-Core Version:    0.7.0.1
 */