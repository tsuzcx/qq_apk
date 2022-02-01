package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.security.FrozenNotifyDlgHelper;

class NotificationActivity$25
  implements DialogInterface.OnClickListener
{
  NotificationActivity$25(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FrozenNotifyDlgHelper.a().a((BaseQQAppInterface)this.a.getAppRuntime(), NotificationActivity.access$600(this.a), 2, NotificationActivity.access$300(this.a));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.25
 * JD-Core Version:    0.7.0.1
 */