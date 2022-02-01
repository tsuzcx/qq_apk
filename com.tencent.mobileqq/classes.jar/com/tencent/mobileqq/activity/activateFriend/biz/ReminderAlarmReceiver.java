package com.tencent.mobileqq.activity.activateFriend.biz;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import anyr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ReminderAlarmReceiver
  extends BroadcastReceiver
{
  private static final String jdField_a_of_type_JavaLangString = ReminderAlarmReceiver.class.getSimpleName();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public ReminderAlarmReceiver(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("notification_alram_action".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("msg");
      paramIntent = paramIntent.getStringExtra("msg_id");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "---" + paramContext + "---msgId---" + paramIntent);
      }
      ((anyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(85)).a(paramContext, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.ReminderAlarmReceiver
 * JD-Core Version:    0.7.0.1
 */