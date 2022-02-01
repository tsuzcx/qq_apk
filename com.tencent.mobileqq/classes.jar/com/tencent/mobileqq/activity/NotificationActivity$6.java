package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class NotificationActivity$6
  extends BroadcastReceiver
{
  NotificationActivity$6(NotificationActivity paramNotificationActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equals("com.tencent.mobileqq.closeNotification")) && (NotificationActivity.access$100(this.a) == 5)) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.6
 * JD-Core Version:    0.7.0.1
 */