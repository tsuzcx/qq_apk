package com.tencent.mobileqq.activity.qwallet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class SendHbActivity$1
  extends BroadcastReceiver
{
  SendHbActivity$1(SendHbActivity paramSendHbActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.qwallet.report".equals(paramIntent.getAction()))
    {
      int i = paramIntent.getIntExtra("type", 0);
      QLog.i("SendHbActivity", 2, "onReceive type = " + i);
      if (999 == i) {
        break label53;
      }
    }
    label53:
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getBundleExtra("params");
      } while (paramContext == null);
      QLog.i("SendHbActivity", 2, "onReceive bundle = " + paramContext.toString());
      paramContext = paramContext.getString("from");
    } while ((this.a.isFinishing()) || (!"video".equals(paramContext)));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.SendHbActivity.1
 * JD-Core Version:    0.7.0.1
 */