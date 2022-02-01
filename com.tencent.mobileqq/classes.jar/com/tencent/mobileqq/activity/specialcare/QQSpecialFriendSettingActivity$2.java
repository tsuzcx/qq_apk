package com.tencent.mobileqq.activity.specialcare;

import com.tencent.qphone.base.util.QLog;

class QQSpecialFriendSettingActivity$2
  implements QvipSpecialSoundManager.CallBack
{
  QQSpecialFriendSettingActivity$2(QQSpecialFriendSettingActivity paramQQSpecialFriendSettingActivity) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "loadSpecialSoundConfig onResult: " + paramBoolean);
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        QQSpecialFriendSettingActivity.a(this.a);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      finally
      {
        this.a.stopTitleProgress();
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQSpecialFriendSettingActivity", 2, "loadSpecialSoundConfig fail.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity.2
 * JD-Core Version:    0.7.0.1
 */