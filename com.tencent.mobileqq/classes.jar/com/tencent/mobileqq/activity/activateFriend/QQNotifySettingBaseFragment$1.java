package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsGetMsgRsp;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class QQNotifySettingBaseFragment$1
  implements BusinessObserver
{
  QQNotifySettingBaseFragment$1(QQNotifySettingBaseFragment paramQQNotifySettingBaseFragment) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((QQNotifySettingBaseFragment.a(this.a).isShowing()) && (QQNotifySettingBaseFragment.a(this.a) != null)) {
      QQNotifySettingBaseFragment.a(this.a).dismiss();
    }
    if (paramInt == 2005)
    {
      if (QLog.isColorLevel()) {
        QLog.d(QQNotifySettingBaseFragment.a(), 2, "acs msg succ");
      }
      if (paramBoolean)
      {
        paramBundle = (AcsGetMsgRsp)paramBundle.getSerializable("rsp");
        QQNotifySettingBaseFragment localQQNotifySettingBaseFragment = this.a;
        QQNotifySettingBaseFragment.a(localQQNotifySettingBaseFragment, QQNotifySettingBaseFragment.a(localQQNotifySettingBaseFragment, paramBundle));
        if (paramBundle != null)
        {
          QQNotifySettingBaseFragment.a(this.a).post(new QQNotifySettingBaseFragment.1.1(this, paramBundle));
          return;
        }
        QQNotifySettingBaseFragment.a(this.a).post(new QQNotifySettingBaseFragment.1.2(this));
        return;
      }
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */