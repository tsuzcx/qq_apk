package com.tencent.mobileqq.activity.specialcare;

import apzv;
import aqac;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public final class SpecialCareUtils$1
  implements Runnable
{
  public SpecialCareUtils$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (apzv.a().a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("SpecialCareUtils", 2, "preLoadSpecialCareSettingPage");
      }
      aqac.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecialCareUtils.1
 * JD-Core Version:    0.7.0.1
 */