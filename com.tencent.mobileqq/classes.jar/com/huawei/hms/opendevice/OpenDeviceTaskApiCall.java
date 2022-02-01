package com.huawei.hms.opendevice;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.opendevice.OdidResp;
import com.huawei.hms.support.api.opendevice.OdidResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

public class OpenDeviceTaskApiCall
  extends TaskApiCall<OpenDeviceHmsClient, OdidResult>
{
  public OpenDeviceTaskApiCall(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, paramString3);
  }
  
  protected void doExecute(OpenDeviceHmsClient paramOpenDeviceHmsClient, ResponseErrorCode paramResponseErrorCode, String paramString, TaskCompletionSource<OdidResult> paramTaskCompletionSource)
  {
    if (paramResponseErrorCode == null)
    {
      paramTaskCompletionSource.setException(new ApiException(new Status(1)));
      return;
    }
    HiAnalyticsClient.reportExit(paramOpenDeviceHmsClient.getContext(), getUri(), getTransactionId(), paramResponseErrorCode.getStatusCode(), paramResponseErrorCode.getErrorCode(), 50002300);
    if (paramResponseErrorCode.getErrorCode() == 0)
    {
      HMSLog.i("OpenDeviceTaskApiCall", "onResult, success");
      paramOpenDeviceHmsClient = new OdidResp();
      JsonUtil.jsonToEntity(paramString, paramOpenDeviceHmsClient);
      paramResponseErrorCode = new OdidResult();
      paramResponseErrorCode.setId(paramOpenDeviceHmsClient.getId());
      paramResponseErrorCode.setStatus(new Status(0));
      paramTaskCompletionSource.setResult(paramResponseErrorCode);
      return;
    }
    HMSLog.i("OpenDeviceTaskApiCall", "onResult, returnCode: " + paramResponseErrorCode.getErrorCode());
    paramTaskCompletionSource.setException(new ApiException(new Status(paramResponseErrorCode.getErrorCode(), paramResponseErrorCode.getErrorReason())));
  }
  
  public int getApiLevel()
  {
    return 2;
  }
  
  public int getMinApkVersion()
  {
    return 50002300;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.opendevice.OpenDeviceTaskApiCall
 * JD-Core Version:    0.7.0.1
 */