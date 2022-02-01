package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.qphone.base.util.QLog;

class QQSettingMe$41
  extends SVIPObserver
{
  QQSettingMe$41(QQSettingMe paramQQSettingMe) {}
  
  public void onVipStatusChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "updateLevelAndVip from mVipInfoChangedObserver");
    }
    this.a.c(this.a.a.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.41
 * JD-Core Version:    0.7.0.1
 */