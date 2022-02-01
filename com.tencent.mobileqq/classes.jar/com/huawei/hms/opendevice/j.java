package com.huawei.hms.opendevice;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.entity.DeleteTokenResp;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

public class j
  extends TaskApiCall<l, Void>
{
  public j(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, paramString3);
  }
  
  protected void doExecute(l paraml, ResponseErrorCode paramResponseErrorCode, String paramString, TaskCompletionSource<Void> paramTaskCompletionSource)
  {
    if (paramResponseErrorCode.getErrorCode() != 0)
    {
      HMSLog.e(HmsInstanceId.TAG, "DeleteTokenTask failed, ErrorCode: " + paramResponseErrorCode.getErrorCode());
      paraml = a.a(paramResponseErrorCode.getErrorCode());
      if (paraml != a.g)
      {
        paramTaskCompletionSource.setException(a.a(paraml));
        return;
      }
      paramTaskCompletionSource.setException(new ApiException(new Status(paramResponseErrorCode.getErrorCode(), paramResponseErrorCode.getErrorReason())));
      return;
    }
    paramString = a.a(((DeleteTokenResp)JsonUtil.jsonToEntity(paramString, new DeleteTokenResp())).getRetCode());
    if (paramString != a.a)
    {
      paramTaskCompletionSource.setException(a.a(paramString));
      return;
    }
    paramTaskCompletionSource.setResult(null);
    p.a(paraml.getContext(), getUri(), paramResponseErrorCode);
  }
  
  public int getMinApkVersion()
  {
    return 30000000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.opendevice.j
 * JD-Core Version:    0.7.0.1
 */