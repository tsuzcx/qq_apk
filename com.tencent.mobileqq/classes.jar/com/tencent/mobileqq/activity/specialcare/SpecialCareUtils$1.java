package com.tencent.mobileqq.activity.specialcare;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flutter.config.QFlutterDPC;
import com.tencent.mobileqq.flutter.download.QFlutterInstaller;
import com.tencent.qphone.base.util.QLog;

final class SpecialCareUtils$1
  implements Runnable
{
  SpecialCareUtils$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (QFlutterDPC.a().a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("SpecialCareUtils", 2, "preLoadSpecialCareSettingPage");
      }
      QFlutterInstaller.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecialCareUtils.1
 * JD-Core Version:    0.7.0.1
 */