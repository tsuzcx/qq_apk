package com.tencent.mobileqq.activity.specialcare;

import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.qphone.base.util.QLog;

class QQSpecialCareSettingActivity$5
  extends QvipSpecialCareObserver
{
  QQSpecialCareSettingActivity$5(QQSpecialCareSettingActivity paramQQSpecialCareSettingActivity) {}
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "onSpecialSoundEvent data: " + paramObject);
    }
    if (paramObject != null) {
      this.a.stopTitleProgress();
    }
    switch (((Integer)paramObject).intValue())
    {
    default: 
      return;
    }
    QQSpecialCareSettingActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity.5
 * JD-Core Version:    0.7.0.1
 */