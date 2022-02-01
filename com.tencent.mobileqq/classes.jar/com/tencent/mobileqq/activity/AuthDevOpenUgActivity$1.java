package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.widget.QQToast;
import mqq.manager.AccountManager;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class AuthDevOpenUgActivity$1
  extends WtloginObserver
{
  AuthDevOpenUgActivity$1(AuthDevOpenUgActivity paramAuthDevOpenUgActivity) {}
  
  public void onCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (paramInt == 0)
    {
      paramWUserSigInfo = (AccountManager)this.a.app.getManager(0);
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.refreshDA2(this.a.app.getCurrentAccountUin(), null);
      }
      paramWUserSigInfo = EquipmentLockImpl.a();
      paramErrMsg = this.a.app;
      AuthDevOpenUgActivity localAuthDevOpenUgActivity = this.a;
      paramWUserSigInfo.a(paramErrMsg, localAuthDevOpenUgActivity, localAuthDevOpenUgActivity.app.getCurrentAccountUin(), true);
      QQToast.a(this.a.getApplicationContext(), 2, this.a.getString(2131691980), 0).b(this.a.getTitleBarHeight());
      paramWUserSigInfo = this.a.app.getHandler(LoginInfoActivity.class);
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.obtainMessage(20140331, 1, 0).sendToTarget();
      }
      AuthDevOpenUgActivity.access$100(this.a, true, 0);
      paramErrMsg = new Intent();
      paramErrMsg.putExtra("auth_dev_open", true);
      if (AuthDevOpenUgActivity.access$200(this.a) != null) {
        paramWUserSigInfo = AuthDevOpenUgActivity.access$200(this.a).Mobile;
      } else {
        paramWUserSigInfo = "";
      }
      paramErrMsg.putExtra("phone_num", paramWUserSigInfo);
      this.a.finishSelf(-1, paramErrMsg);
      return;
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      QQToast.a(this.a.getApplicationContext(), 1, paramErrMsg.getMessage(), 0).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 1, this.a.getString(2131692022), 0).b(this.a.getTitleBarHeight());
  }
  
  public void onCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if ((paramInt == 0) && (paramDevlockInfo != null))
    {
      AuthDevOpenUgActivity.access$000(this.a, paramDevlockInfo);
      return;
    }
    paramWUserSigInfo = this.a;
    QQToast.a(paramWUserSigInfo, paramWUserSigInfo.getString(2131692031), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevOpenUgActivity.1
 * JD-Core Version:    0.7.0.1
 */