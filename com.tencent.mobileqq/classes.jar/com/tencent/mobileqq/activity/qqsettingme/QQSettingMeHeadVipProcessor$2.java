package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.qphone.base.util.QLog;

class QQSettingMeHeadVipProcessor$2
  extends SVIPObserver
{
  QQSettingMeHeadVipProcessor$2(QQSettingMeHeadVipProcessor paramQQSettingMeHeadVipProcessor) {}
  
  public void onVipStatusChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "updateLevelAndVip from mVipInfoChangedObserver");
    }
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeHeadVipProcessor.2
 * JD-Core Version:    0.7.0.1
 */