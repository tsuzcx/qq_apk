package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CheckBox;

class NotificationActivity$20
  implements DialogInterface.OnClickListener
{
  NotificationActivity$20(NotificationActivity paramNotificationActivity, CheckBox paramCheckBox, boolean paramBoolean, SharedPreferences paramSharedPreferences) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      boolean bool = this.a.isChecked();
      if (this.b != bool) {
        this.c.edit().putBoolean("MemoryAlertAutoClear", bool).commit();
      }
      label39:
      this.d.finish();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label39;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.20
 * JD-Core Version:    0.7.0.1
 */