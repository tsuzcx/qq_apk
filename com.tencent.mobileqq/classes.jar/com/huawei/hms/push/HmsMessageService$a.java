package com.huawei.hms.push;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.hms.support.log.HMSLog;

@SuppressLint({"HandlerLeak"})
public class HmsMessageService$a
  extends Handler
{
  public HmsMessageService$a(HmsMessageService paramHmsMessageService) {}
  
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
      localIntent.putExtras(localBundle);
      localIntent.putExtra("inputType", localBundle.getInt("inputType", -1));
      this.a.handleIntentMessage(localIntent);
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.HmsMessageService.a
 * JD-Core Version:    0.7.0.1
 */