package com.huawei.hms.push.task;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;

public class ProfileTask
  extends BaseVoidTask
{
  public ProfileTask(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, paramString3);
  }
  
  public void doExecute(PushClient paramPushClient, ResponseErrorCode paramResponseErrorCode, String paramString, TaskCompletionSource<Void> paramTaskCompletionSource)
  {
    if (paramResponseErrorCode.getErrorCode() == 0)
    {
      HMSLog.i("HmsInstanceId", "ProfileTask success.");
      paramTaskCompletionSource.setResult(null);
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("ProfileTask failed, ErrorCode: ");
      paramString.append(paramResponseErrorCode.getErrorCode());
      HMSLog.e("HmsInstanceId", paramString.toString());
      paramString = ErrorEnum.fromCode(paramResponseErrorCode.getErrorCode());
      if (paramString != ErrorEnum.ERROR_UNKNOWN) {
        paramTaskCompletionSource.setException(paramString.toApiException());
      } else {
        paramTaskCompletionSource.setException(new ApiException(new Status(paramResponseErrorCode.getErrorCode(), paramResponseErrorCode.getErrorReason())));
      }
    }
    PushBiUtil.reportExit(paramPushClient.getContext(), getUri(), paramResponseErrorCode);
  }
  
  public int getApiLevel()
  {
    return 2;
  }
  
  public int getMinApkVersion()
  {
    return 50004300;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.push.task.ProfileTask
 * JD-Core Version:    0.7.0.1
 */