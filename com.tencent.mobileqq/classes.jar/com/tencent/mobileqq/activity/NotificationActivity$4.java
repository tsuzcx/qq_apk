package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.qphone.base.util.QLog;

class NotificationActivity$4
  implements DialogInterface.OnClickListener
{
  NotificationActivity$4(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.i("NotificationActivity", 1, "setNegativeButton.onClick: invoked.  isDialogShow: " + NotificationActivity.access$000(this.a));
    paramDialogInterface = new Intent("qqplayer_exit_action");
    this.a.sendBroadcast(paramDialogInterface);
    paramDialogInterface = new Bundle();
    paramDialogInterface.putString("password", null);
    paramDialogInterface = new Intent().putExtras(paramDialogInterface).addFlags(67108864);
    RouteUtils.a(this.a, paramDialogInterface, "/base/login");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.4
 * JD-Core Version:    0.7.0.1
 */