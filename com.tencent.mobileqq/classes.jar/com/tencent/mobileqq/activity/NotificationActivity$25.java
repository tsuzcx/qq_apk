package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.security.FrozenNotifyDlgHelper;

class NotificationActivity$25
  implements DialogInterface.OnClickListener
{
  NotificationActivity$25(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FrozenNotifyDlgHelper.a().a(this.a.app, NotificationActivity.access$500(this.a), 2, NotificationActivity.access$200(this.a));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.25
 * JD-Core Version:    0.7.0.1
 */