package com.huawei.hms.push;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;

public class d
  extends TaskApiCall<h, b>
{
  private String a;
  private String b;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super(paramString1, paramString2, paramString3);
    this.a = paramString4;
    this.b = paramString5;
  }
  
  private void a(h paramh, ResponseErrorCode paramResponseErrorCode)
  {
    HMSLog.i("SendUpStreamTask", "receive upstream, msgId :" + this.b + " , packageName = " + this.a + " , errorCode = " + paramResponseErrorCode.getErrorCode());
    Intent localIntent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
    localIntent.setPackage(this.a);
    Bundle localBundle = new Bundle();
    localBundle.putString("message_id", this.b);
    localBundle.putInt("error", paramResponseErrorCode.getErrorCode());
    if (a.a.a() == paramResponseErrorCode.getErrorCode()) {
      localBundle.putString("message_type", "sent_message");
    }
    while (new l().a(paramh.getContext(), localBundle, localIntent))
    {
      HMSLog.i("SendUpStreamTask", "receive upstream, start service success");
      g.a(paramh.getContext(), getUri(), paramResponseErrorCode);
      return;
      localBundle.putString("message_type", "send_error");
    }
    HMSLog.w("SendUpStreamTask", "receive upstream, start service failed");
    g.a(paramh.getContext(), getUri(), paramResponseErrorCode.getTransactionId(), a.ap);
  }
  
  protected void doExecute(h paramh, ResponseErrorCode paramResponseErrorCode, String paramString, TaskCompletionSource<b> paramTaskCompletionSource)
  {
    if (paramResponseErrorCode.getErrorCode() == 0)
    {
      HMSLog.i("SendUpStreamTask", "send up stream task,Operate succeed");
      paramTaskCompletionSource.setResult(null);
    }
    for (;;)
    {
      a(paramh, paramResponseErrorCode);
      return;
      HMSLog.e("SendUpStreamTask", "send up stream task,Operate failed with ret=" + paramResponseErrorCode.getErrorCode());
      paramString = a.a(paramResponseErrorCode.getErrorCode());
      if (paramString != a.g) {
        paramTaskCompletionSource.setException(a.a(paramString));
      } else {
        paramTaskCompletionSource.setException(new ApiException(new Status(paramResponseErrorCode.getErrorCode(), paramResponseErrorCode.getErrorReason())));
      }
    }
  }
  
  public int getMinApkVersion()
  {
    return 40003000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.d
 * JD-Core Version:    0.7.0.1
 */