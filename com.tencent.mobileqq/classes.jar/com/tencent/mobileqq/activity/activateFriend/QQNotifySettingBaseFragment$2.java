package com.tencent.mobileqq.activity.activateFriend;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class QQNotifySettingBaseFragment$2
  implements BusinessObserver
{
  QQNotifySettingBaseFragment$2(QQNotifySettingBaseFragment paramQQNotifySettingBaseFragment, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 2002)
    {
      if (paramBoolean) {}
      try
      {
        QQNotifySettingBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment).post(new QQNotifySettingBaseFragment.2.1(this, paramBundle));
        return;
      }
      catch (Throwable paramBundle)
      {
        QLog.e(QQNotifySettingBaseFragment.a(), 1, QLog.getStackTraceString(paramBundle));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifySettingBaseFragment.b(3, "system error");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment.2
 * JD-Core Version:    0.7.0.1
 */