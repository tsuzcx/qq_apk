package com.tencent.mobileqq.activity.specialcare;

import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.qphone.base.util.QLog;

class QQSpecialCareSettingActivity$5
  extends QvipSpecialCareObserver
{
  QQSpecialCareSettingActivity$5(QQSpecialCareSettingActivity paramQQSpecialCareSettingActivity) {}
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSpecialSoundEvent data: ");
      localStringBuilder.append(paramObject);
      QLog.d("QQSpecialCareSettingActivity", 2, localStringBuilder.toString());
    }
    if (paramObject != null)
    {
      this.a.stopTitleProgress();
      int i = ((Integer)paramObject).intValue();
      if ((i != 2) && (i != 3) && (i != 4)) {
        return;
      }
      QQSpecialCareSettingActivity.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity.5
 * JD-Core Version:    0.7.0.1
 */