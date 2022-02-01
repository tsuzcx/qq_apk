package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class NotificationActivity$8$1
  implements DialogInterface.OnClickListener
{
  NotificationActivity$8$1(NotificationActivity.8 param8) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new NotificationActivity.8.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.8.1
 * JD-Core Version:    0.7.0.1
 */