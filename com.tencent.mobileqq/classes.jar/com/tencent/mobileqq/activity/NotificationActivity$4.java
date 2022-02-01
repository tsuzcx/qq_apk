package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qqsec.api.ISecControllerInterface;
import com.tencent.qphone.base.util.QLog;

class NotificationActivity$4
  implements DialogInterface.OnClickListener
{
  NotificationActivity$4(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new StringBuilder();
    paramDialogInterface.append("setNegativeButton.onClick: invoked.  isDialogShow: ");
    paramDialogInterface.append(NotificationActivity.access$000(this.a));
    QLog.i("NotificationActivity", 1, paramDialogInterface.toString());
    NotificationActivity.access$100().a(this.a, false, false);
    paramDialogInterface = new Bundle();
    paramDialogInterface.putString("password", null);
    paramDialogInterface = new Intent().putExtras(paramDialogInterface).addFlags(67108864);
    RouteUtils.a(this.a, paramDialogInterface, "/base/login");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.4
 * JD-Core Version:    0.7.0.1
 */