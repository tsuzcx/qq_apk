package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.HmsInstanceIdEx;
import com.huawei.hms.aaid.entity.TokenResp;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.task.ReportAaidToken;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

public class k
  extends TaskApiCall<l, TokenResult>
{
  private Context a;
  
  public k(String paramString1, String paramString2, Context paramContext, String paramString3)
  {
    super(paramString1, paramString2, paramString3);
    this.a = paramContext;
  }
  
  protected void doExecute(l paraml, ResponseErrorCode paramResponseErrorCode, String paramString, TaskCompletionSource<TokenResult> paramTaskCompletionSource)
  {
    if (paramResponseErrorCode.getErrorCode() != 0)
    {
      HMSLog.e(HmsInstanceIdEx.TAG, "TokenTask failed, ErrorCode: " + paramResponseErrorCode.getErrorCode());
      paramString = a.a(paramResponseErrorCode.getErrorCode());
      if (paramString != a.g) {
        paramTaskCompletionSource.setException(a.a(paramString));
      }
    }
    for (;;)
    {
      p.a(paraml.getContext(), getUri(), paramResponseErrorCode);
      return;
      paramTaskCompletionSource.setException(new ApiException(new Status(paramResponseErrorCode.getErrorCode(), paramResponseErrorCode.getErrorReason())));
      continue;
      paramString = (TokenResp)JsonUtil.jsonToEntity(paramString, new TokenResp());
      Object localObject = a.a(paramString.getRetCode());
      if (localObject != a.a)
      {
        paramTaskCompletionSource.setException(a.a((a)localObject));
        HMSLog.e(HmsInstanceIdEx.TAG, "TokenTask failed, StatusCode:" + ((a)localObject).a());
      }
      else
      {
        localObject = new TokenResult();
        ((TokenResult)localObject).setToken(paramString.getToken());
        ((TokenResult)localObject).setBelongId(paramString.getBelongId());
        ((TokenResult)localObject).setRetCode(a.a(paramString.getRetCode()).a());
        paramTaskCompletionSource.setResult(localObject);
        paramString = paramString.getToken();
        if (TextUtils.isEmpty(paramString))
        {
          HMSLog.i(HmsInstanceId.TAG, "GetTokenTask receive a empty token, please check HmsMessageService.onNewToken receive result.");
          p.a(paraml.getContext(), getUri(), paramResponseErrorCode);
          return;
        }
        if (!c.a(this.a, "push_client_self_info").equals(paramString))
        {
          HMSLog.i(HmsInstanceId.TAG, "receive a token, refresh the local token");
          c.a(this.a, "push_client_self_info", paramString);
        }
        ReportAaidToken.report(this.a, paramString);
      }
    }
  }
  
  public int getMinApkVersion()
  {
    return 30000000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.opendevice.k
 * JD-Core Version:    0.7.0.1
 */