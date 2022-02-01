package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CheckBox;
import com.tencent.qqperf.monitor.memory.MemoryManager;

class NotificationActivity$21
  implements DialogInterface.OnClickListener
{
  NotificationActivity$21(NotificationActivity paramNotificationActivity, CheckBox paramCheckBox, boolean paramBoolean, SharedPreferences paramSharedPreferences) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      try
      {
        boolean bool = this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked();
        if (this.jdField_a_of_type_Boolean != bool) {
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("MemoryAlertAutoClear", bool).commit();
        }
        MemoryManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity, NotificationActivity.class, 10);
      }
      finally
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.finish();
      }
    }
    catch (Exception paramDialogInterface)
    {
      label66:
      break label66;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.21
 * JD-Core Version:    0.7.0.1
 */