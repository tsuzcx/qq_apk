package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VipGrayConfigHelper.VipGrayConfigListener;
import com.tencent.qphone.base.util.QLog;

class QQSettingMe$42
  implements VipGrayConfigHelper.VipGrayConfigListener
{
  QQSettingMe$42(QQSettingMe paramQQSettingMe) {}
  
  public void a()
  {
    if (this.a.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "enterWordListener");
      }
      this.a.c(this.a.a.getAccount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.42
 * JD-Core Version:    0.7.0.1
 */