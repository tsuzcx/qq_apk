package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class QQSettingMeWeatherListener$1
  implements QQPermissionCallback
{
  QQSettingMeWeatherListener$1(QQSettingMeWeatherListener paramQQSettingMeWeatherListener, QQSettingMe paramQQSettingMe) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("QQSettingRedesign", 1, "User requestPermissions denied...");
    DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("QQSettingRedesign", 1, "User requestPermissions grant...");
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMeWeatherListener.1
 * JD-Core Version:    0.7.0.1
 */