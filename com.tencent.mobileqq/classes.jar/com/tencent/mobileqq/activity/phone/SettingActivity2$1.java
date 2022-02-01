package com.tencent.mobileqq.activity.phone;

import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.qphone.base.util.QLog;

class SettingActivity2$1
  implements Runnable
{
  SettingActivity2$1(SettingActivity2 paramSettingActivity2) {}
  
  public void run()
  {
    boolean bool = PermissionChecker.a().e();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnResume : ");
      localStringBuilder.append(bool);
      QLog.i("SettingActivity2", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SettingActivity2.1
 * JD-Core Version:    0.7.0.1
 */