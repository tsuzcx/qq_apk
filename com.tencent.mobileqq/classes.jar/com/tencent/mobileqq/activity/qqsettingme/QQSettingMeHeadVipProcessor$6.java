package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.qphone.base.util.QLog;

class QQSettingMeHeadVipProcessor$6
  implements Runnable
{
  QQSettingMeHeadVipProcessor$6(QQSettingMeHeadVipProcessor paramQQSettingMeHeadVipProcessor) {}
  
  public void run()
  {
    try
    {
      QQSettingMeHeadVipProcessor.a(this.this$0);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update level and vip fail :");
      localStringBuilder.append(localThrowable);
      QLog.e("QQSettingRedesign", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeHeadVipProcessor.6
 * JD-Core Version:    0.7.0.1
 */