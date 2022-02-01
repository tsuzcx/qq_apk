package com.huawei.hms.push.task;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.push.h;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;

public class SendUpStreamTask
  extends TaskApiCall<PushClient, BaseVoidTask>
{
  public String a;
  public String b;
  
  public SendUpStreamTask(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super(paramString1, paramString2, paramString3);
    this.a = paramString4;
    this.b = paramString5;
  }
  
  public final void a(PushClient paramPushClient, ResponseErrorCode paramResponseErrorCode)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("receive upstream, msgId :");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(" , packageName = ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" , errorCode = ");
    ((StringBuilder)localObject).append(paramResponseErrorCode.getErrorCode());
    HMSLog.i("SendUpStreamTask", ((StringBuilder)localObject).toString());
    localObject = new Intent("com.huawei.push.action.MESSAGING_EVENT");
    ((Intent)localObject).setPackage(this.a);
    Bundle localBundle = new Bundle();
    localBundle.putString("message_id", this.b);
    localBundle.putInt("error", paramResponseErrorCode.getErrorCode());
    if (ErrorEnum.SUCCESS.getInternalCode() == paramResponseErrorCode.getErrorCode()) {
      localBundle.putString("message_type", "sent_message");
    } else {
      localBundle.putString("message_type", "send_error");
    }
    if (new h().a(paramPushClient.getContext(), localBundle, (Intent)localObject))
    {
      HMSLog.i("SendUpStreamTask", "receive upstream, start service success");
      PushBiUtil.reportExit(paramPushClient.getContext(), getUri(), paramResponseErrorCode);
      return;
    }
    HMSLog.w("SendUpStreamTask", "receive upstream, start service failed");
    PushBiUtil.reportExit(paramPushClient.getContext(), getUri(), paramResponseErrorCode.getTransactionId(), ErrorEnum.ERROR_BIND_SERVICE_SELF_MAPPING);
  }
  
  public void doExecute(PushClient paramPushClient, ResponseErrorCode paramResponseErrorCode, String paramString, TaskCompletionSource<BaseVoidTask> paramTaskCompletionSource)
  {
    if (paramResponseErrorCode.getErrorCode() == 0)
    {
      HMSLog.i("SendUpStreamTask", "send up stream task,Operate succeed");
      paramTaskCompletionSource.setResult(null);
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("send up stream task,Operate failed with ret=");
      paramString.append(paramResponseErrorCode.getErrorCode());
      HMSLog.e("SendUpStreamTask", paramString.toString());
      paramString = ErrorEnum.fromCode(paramResponseErrorCode.getErrorCode());
      if (paramString != ErrorEnum.ERROR_UNKNOWN) {
        paramTaskCompletionSource.setException(paramString.toApiException());
      } else {
        paramTaskCompletionSource.setException(new ApiException(new Status(paramResponseErrorCode.getErrorCode(), paramResponseErrorCode.getErrorReason())));
      }
    }
    a(paramPushClient, paramResponseErrorCode);
  }
  
  public int getMinApkVersion()
  {
    return 40003000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.task.SendUpStreamTask
 * JD-Core Version:    0.7.0.1
 */