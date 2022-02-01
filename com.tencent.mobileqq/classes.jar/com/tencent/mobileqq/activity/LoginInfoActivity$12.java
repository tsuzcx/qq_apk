package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class LoginInfoActivity$12
  extends WtloginObserver
{
  LoginInfoActivity$12(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void onCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.a.isFinishing()) {
      return;
    }
    if ((paramInt == 0) && (paramDevlockInfo != null))
    {
      if (QLog.isColorLevel())
      {
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("OnCheckDevLockStatus ret = ");
        paramWUserSigInfo.append(paramInt);
        QLog.d("LoginInfoActivity.AccDevSec", 2, paramWUserSigInfo.toString());
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("DevlockInfo devSetup:");
        paramWUserSigInfo.append(paramDevlockInfo.DevSetup);
        paramWUserSigInfo.append(" countryCode:");
        paramWUserSigInfo.append(paramDevlockInfo.CountryCode);
        paramWUserSigInfo.append(" mobile:");
        paramWUserSigInfo.append(paramDevlockInfo.Mobile);
        paramWUserSigInfo.append(" MbItemSmsCodeStatus:");
        paramWUserSigInfo.append(paramDevlockInfo.MbItemSmsCodeStatus);
        paramWUserSigInfo.append(" TimeLimit:");
        paramWUserSigInfo.append(paramDevlockInfo.TimeLimit);
        paramWUserSigInfo.append(" AvailableMsgCount:");
        paramWUserSigInfo.append(paramDevlockInfo.AvailableMsgCount);
        paramWUserSigInfo.append(" AllowSet:");
        paramWUserSigInfo.append(paramDevlockInfo.AllowSet);
        QLog.d("LoginInfoActivity.AccDevSec", 2, paramWUserSigInfo.toString());
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("DevlockInfo.ProtectIntro:");
        paramWUserSigInfo.append(paramDevlockInfo.ProtectIntro);
        paramWUserSigInfo.append("  info.MbGuideType:");
        paramWUserSigInfo.append(paramDevlockInfo.MbGuideType);
        QLog.d("LoginInfoActivity.AccDevSec", 2, paramWUserSigInfo.toString());
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("DevlockInfo.MbGuideMsg:");
        paramWUserSigInfo.append(paramDevlockInfo.MbGuideMsg);
        QLog.d("LoginInfoActivity.AccDevSec", 2, paramWUserSigInfo.toString());
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("DevlockInfo.MbGuideInfoType:");
        paramWUserSigInfo.append(paramDevlockInfo.MbGuideInfoType);
        QLog.d("LoginInfoActivity.AccDevSec", 2, paramWUserSigInfo.toString());
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("DevlockInfo.MbGuideInfo:");
        paramWUserSigInfo.append(paramDevlockInfo.MbGuideInfo);
        QLog.d("LoginInfoActivity.AccDevSec", 2, paramWUserSigInfo.toString());
      }
      DevlockPhoneStatus.a().a(paramDevlockInfo.TransferInfo);
      LoginInfoActivity.access$202(this.a, paramDevlockInfo);
      paramWUserSigInfo = this.a;
      LoginInfoActivity.access$300(paramWUserSigInfo, LoginInfoActivity.access$200(paramWUserSigInfo));
      paramWUserSigInfo = this.a;
      LoginInfoActivity.access$2500(paramWUserSigInfo, LoginInfoActivity.access$200(paramWUserSigInfo));
      return;
    }
    if (QLog.isColorLevel())
    {
      paramWUserSigInfo = new StringBuilder();
      paramWUserSigInfo.append("OnCheckDevLockStatus ret = ");
      paramWUserSigInfo.append(paramInt);
      QLog.d("LoginInfoActivity.AccDevSec", 2, paramWUserSigInfo.toString());
      if (paramErrMsg != null)
      {
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("OnCheckDevLockStatus errMsg:");
        paramWUserSigInfo.append(paramErrMsg.getMessage());
        QLog.d("LoginInfoActivity.AccDevSec", 2, paramWUserSigInfo.toString());
      }
      if (paramDevlockInfo == null) {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "OnCheckDevLockStatus DevlockInfo is null");
      }
    }
    LoginInfoActivity.access$2600(this.a);
    paramDevlockInfo = this.a.getString(2131692013);
    paramWUserSigInfo = paramDevlockInfo;
    if (paramErrMsg != null)
    {
      paramWUserSigInfo = paramDevlockInfo;
      if (!TextUtils.isEmpty(paramErrMsg.getMessage())) {
        paramWUserSigInfo = paramErrMsg.getMessage();
      }
    }
    QQToast.a(this.a.getApplicationContext(), paramWUserSigInfo, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.12
 * JD-Core Version:    0.7.0.1
 */