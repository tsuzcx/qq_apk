package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.qphone.base.util.QLog;

class QQSettingMeSuperMemberProcessor$5
  implements Runnable
{
  QQSettingMeSuperMemberProcessor$5(QQSettingMeSuperMemberProcessor paramQQSettingMeSuperMemberProcessor) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "init parse config json");
    }
    VipGrayConfigHelper.a().a(this.this$0.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSuperMemberProcessor.5
 * JD-Core Version:    0.7.0.1
 */