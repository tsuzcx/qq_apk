package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mqq.os.MqqHandler;

class NotificationActivity$MyDialogClickListener
  implements DialogInterface.OnClickListener
{
  private int b;
  
  public NotificationActivity$MyDialogClickListener(NotificationActivity paramNotificationActivity, int paramInt)
  {
    this.b = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = this.b;
      if (paramInt == 1)
      {
        NotificationActivity.access$2000(this.a);
        NotificationActivity.access$1600(this.a).sendEmptyMessage(4);
        return;
      }
      if (paramInt == 2)
      {
        paramDialogInterface = this.a;
        NotificationActivity.access$1800(paramDialogInterface, NotificationActivity.access$1700(paramDialogInterface));
      }
    }
    else if (paramInt == 1)
    {
      NotificationActivity.access$2100(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.MyDialogClickListener
 * JD-Core Version:    0.7.0.1
 */