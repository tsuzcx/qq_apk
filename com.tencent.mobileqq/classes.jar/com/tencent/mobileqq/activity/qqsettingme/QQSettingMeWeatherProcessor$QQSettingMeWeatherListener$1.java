package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class QQSettingMeWeatherProcessor$QQSettingMeWeatherListener$1
  implements QQPermissionCallback
{
  QQSettingMeWeatherProcessor$QQSettingMeWeatherListener$1(QQSettingMeWeatherProcessor.QQSettingMeWeatherListener paramQQSettingMeWeatherListener) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("QQSettingRedesign", 1, "User requestPermissions denied...");
    DialogUtil.a(this.a.a.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("QQSettingRedesign", 1, "User requestPermissions grant...");
    QQSettingMeWeatherProcessor.a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeWeatherProcessor.QQSettingMeWeatherListener.1
 * JD-Core Version:    0.7.0.1
 */