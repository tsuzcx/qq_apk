package com.tencent.mobileqq.activity.specialcare;

import arxg;
import arxo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public final class SpecialCareUtils$1
  implements Runnable
{
  public SpecialCareUtils$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (arxg.a().a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("SpecialCareUtils", 2, "preLoadSpecialCareSettingPage");
      }
      arxo.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecialCareUtils.1
 * JD-Core Version:    0.7.0.1
 */