package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;

class NotifyPushSettingActivity$26
  extends BroadcastReceiver
{
  NotifyPushSettingActivity$26(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive"))
    {
      paramContext = paramIntent.getStringExtra("uin");
      NotifyPushSettingActivity.a(this.a, paramContext);
      return;
    }
    if (paramContext.equals("com.tencent.mobileqq.activity.NotifyPushSettingActivity.ConfigPCActive"))
    {
      paramContext = paramIntent.getStringExtra("uin");
      boolean bool = paramIntent.getBooleanExtra("configPCActive", false);
      if (this.a.app.getAccount().equals(paramContext))
      {
        if (true == bool)
        {
          NotifyPushSettingActivity.g(this.a).setVisibility(0);
          return;
        }
        NotifyPushSettingActivity.g(this.a).setVisibility(8);
      }
    }
    else if (paramContext.equals("com.tencent.mobileqq.activity.NotifyPushSettingActivity.HelloLiveMessage"))
    {
      paramContext = paramIntent.getStringExtra("uin");
      NotifyPushSettingActivity.b(this.a, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity.26
 * JD-Core Version:    0.7.0.1
 */