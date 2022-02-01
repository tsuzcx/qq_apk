package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResp;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

public class l
  extends TaskApiCall<PushClient, TokenResult>
{
  public Context a;
  public TokenReq b;
  
  public l(String paramString1, TokenReq paramTokenReq, Context paramContext, String paramString2)
  {
    super(paramString1, JsonUtil.createJsonString(paramTokenReq), paramString2);
    this.a = paramContext;
    this.b = paramTokenReq;
  }
  
  public void a(PushClient paramPushClient, ResponseErrorCode paramResponseErrorCode, String paramString, TaskCompletionSource<TokenResult> paramTaskCompletionSource)
  {
    Object localObject;
    if (paramResponseErrorCode.getErrorCode() != 0)
    {
      paramString = HmsInstanceId.TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TokenTask failed, ErrorCode: ");
      ((StringBuilder)localObject).append(paramResponseErrorCode.getErrorCode());
      HMSLog.e(paramString, ((StringBuilder)localObject).toString());
      paramString = ErrorEnum.fromCode(paramResponseErrorCode.getErrorCode());
      if (paramString != ErrorEnum.ERROR_UNKNOWN) {
        paramTaskCompletionSource.setException(paramString.toApiException());
      } else {
        paramTaskCompletionSource.setException(new ApiException(new Status(paramResponseErrorCode.getErrorCode(), paramResponseErrorCode.getErrorReason())));
      }
    }
    else
    {
      localObject = (TokenResp)JsonUtil.jsonToEntity(paramString, new TokenResp());
      paramString = ErrorEnum.fromCode(((TokenResp)localObject).getRetCode());
      if (paramString != ErrorEnum.SUCCESS)
      {
        paramTaskCompletionSource.setException(paramString.toApiException());
        paramTaskCompletionSource = HmsInstanceId.TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TokenTask failed, StatusCode:");
        ((StringBuilder)localObject).append(paramString.getExternalCode());
        HMSLog.e(paramTaskCompletionSource, ((StringBuilder)localObject).toString());
      }
      else
      {
        paramString = new TokenResult();
        paramString.setToken(((TokenResp)localObject).getToken());
        paramString.setBelongId(((TokenResp)localObject).getBelongId());
        paramString.setRetCode(ErrorEnum.fromCode(((TokenResp)localObject).getRetCode()).getExternalCode());
        paramTaskCompletionSource.setResult(paramString);
        paramString = ((TokenResp)localObject).getToken();
        if (TextUtils.isEmpty(paramString))
        {
          HMSLog.i(HmsInstanceId.TAG, "GetTokenTask receive a empty token, please check HmsMessageService.onNewToken receive result.");
          q.a(paramPushClient.getContext(), getUri(), paramResponseErrorCode);
          return;
        }
        a(paramString, this.b.getSubjectId());
        n.a(this.a, paramString);
      }
    }
    q.a(paramPushClient.getContext(), getUri(), paramResponseErrorCode);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (!i.a(this.a).b(paramString2).equals(paramString1))
    {
      HMSLog.i(HmsInstanceId.TAG, "receive a token, refresh the local token");
      i.a(this.a).b(paramString2, paramString1);
    }
  }
  
  public int getMinApkVersion()
  {
    if (this.b.isMultiSender()) {
      return 50004300;
    }
    return 30000000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.opendevice.l
 * JD-Core Version:    0.7.0.1
 */