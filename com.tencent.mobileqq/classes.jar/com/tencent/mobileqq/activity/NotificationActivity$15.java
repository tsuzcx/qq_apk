package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

class NotificationActivity$15
  implements DialogInterface.OnClickListener
{
  NotificationActivity$15(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SettingCloneUtil.writeValue(this.a.app.getApp(), null, "security_scan_key", "qqsetting_security_scan_key", true);
    this.a.app.startSecurityScan();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.15
 * JD-Core Version:    0.7.0.1
 */