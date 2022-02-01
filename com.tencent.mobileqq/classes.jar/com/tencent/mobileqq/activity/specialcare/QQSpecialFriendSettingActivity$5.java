package com.tencent.mobileqq.activity.specialcare;

import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.qphone.base.util.QLog;

class QQSpecialFriendSettingActivity$5
  extends QvipSpecialCareObserver
{
  QQSpecialFriendSettingActivity$5(QQSpecialFriendSettingActivity paramQQSpecialFriendSettingActivity) {}
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "onSpecialSoundEvent data: " + paramObject);
    }
    if (paramObject != null) {
      this.a.stopTitleProgress();
    }
    switch (((Integer)paramObject).intValue())
    {
    default: 
      return;
    }
    QQSpecialFriendSettingActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity.5
 * JD-Core Version:    0.7.0.1
 */