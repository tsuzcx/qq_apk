package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.qphone.base.util.QLog;

class QQLSActivity$ScreenBroadcastReceiver
  extends BroadcastReceiver
{
  private String jdField_a_of_type_JavaLangString = null;
  
  private QQLSActivity$ScreenBroadcastReceiver(QQLSActivity paramQQLSActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QQLSActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity)) {
      return;
    }
    if (paramIntent != null) {}
    try
    {
      this.jdField_a_of_type_JavaLangString = paramIntent.getAction();
      if ("android.intent.action.SCREEN_ON".equals(this.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "ScreenBroadcastReceiver ACTION_SCREEN_ON");
        }
      }
      else if ("android.intent.action.SCREEN_OFF".equals(this.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "ScreenBroadcastReceiver ACTION_SCREEN_OFF");
        }
      }
      else if ("android.intent.action.USER_PRESENT".equals(this.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("ScreenBroadcastReceiver ACTION_USER_PRESENTmanager.isEnterAio");
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a;
          paramContext.append(QQLSRecentManager.f);
          QLog.d("QQLSActivity", 2, paramContext.toString());
        }
        paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a;
        if (!QQLSRecentManager.f) {
          QQLSActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.finish();
        return;
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("QQLSActivity", 1, paramContext, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.ScreenBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */