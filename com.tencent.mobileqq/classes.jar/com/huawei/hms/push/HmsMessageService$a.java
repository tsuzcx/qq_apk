package com.huawei.hms.push;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.hms.support.log.HMSLog;

@SuppressLint({"HandlerLeak"})
class HmsMessageService$a
  extends Handler
{
  private HmsMessageService$a(HmsMessageService paramHmsMessageService) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null)
    {
      HMSLog.e("HmsMessageService", "receive message is null");
      return;
    }
    HMSLog.i("HmsMessageService", "handle message start ");
    Bundle localBundle = paramMessage.getData();
    if (localBundle != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("message_id", localBundle.getString("message_id"));
      localIntent.putExtra("message_type", localBundle.getString("message_type"));
      localIntent.putExtra("message_body", localBundle.getByteArray("message_body"));
      localIntent.putExtra("device_token", localBundle.getString("device_token"));
      localIntent.putExtra("error", localBundle.getInt("error"));
      localIntent.putExtra("transaction_id", localBundle.getString("transaction_id"));
      localIntent.putExtra("inputType", localBundle.getInt("inputType", -1));
      HmsMessageService.a(this.a, localIntent);
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.HmsMessageService.a
 * JD-Core Version:    0.7.0.1
 */