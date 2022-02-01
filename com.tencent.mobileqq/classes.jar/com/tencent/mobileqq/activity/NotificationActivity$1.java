package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class NotificationActivity$1
  implements DialogInterface.OnClickListener
{
  NotificationActivity$1(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new NotificationActivity.1.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.1
 * JD-Core Version:    0.7.0.1
 */