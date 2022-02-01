package com.tencent.mobileqq.activity;

import android.os.Message;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.identity.ISafeApi;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class AuthDevActivity$6
  extends WtloginObserver
{
  AuthDevActivity$6(AuthDevActivity paramAuthDevActivity) {}
  
  public void onCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.a.isFinishing()) {
      return;
    }
    AuthDevActivity.access$1902(this.a, true);
    AuthDevActivity.access$2000(this.a);
    QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "OnCheckDevLockSms result : ret is ", Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      paramWUserSigInfo = (AccountManager)AuthDevActivity.access$2100(this.a).getManager(0);
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.refreshDA2(AuthDevActivity.access$2200(this.a).getCurrentAccountUin(), null);
      }
      AuthDevActivity.access$200(this.a).setOnCheckedChangeListener(null);
      AuthDevActivity.access$200(this.a).setChecked(true);
      AuthDevActivity.access$200(this.a).setOnCheckedChangeListener(AuthDevActivity.access$2300(this.a));
      AuthDevActivity.access$1300(this.a).getWxMsgOptions(AuthDevActivity.access$2400(this.a));
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCheckDevLockSms.success");
      }
      AuthDevActivity.access$1002(this.a, true);
      paramWUserSigInfo = AuthDevActivity.access$1300(this.a);
      paramErrMsg = AuthDevActivity.access$2500(this.a);
      AuthDevActivity localAuthDevActivity = this.a;
      paramWUserSigInfo.setLocalDevlockStatus(paramErrMsg, localAuthDevActivity, AuthDevActivity.access$2600(localAuthDevActivity).getCurrentAccountUin(), true);
      AuthDevActivity.access$2702(this.a, true);
      QQToast.makeText(this.a.getApplicationContext(), 2, this.a.getString(2131888947), 0).show(this.a.getTitleBarHeight());
      AuthDevActivity.access$2800(this.a);
      paramWUserSigInfo = this.a;
      paramWUserSigInfo = AuthDevActivity.access$2900(paramWUserSigInfo, AuthDevActivity.access$1300(paramWUserSigInfo).getLoginInfoActivity());
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.obtainMessage(20140331, 1, 0).sendToTarget();
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("OnCheckDevLockSms.fail ret=");
        paramWUserSigInfo.append(paramInt);
        QLog.d("Q.devlock.AuthDevActivity", 2, paramWUserSigInfo.toString());
        if (paramErrMsg != null)
        {
          paramWUserSigInfo = new StringBuilder();
          paramWUserSigInfo.append("OnCheckDevLockSms.fail errMsg=");
          paramWUserSigInfo.append(paramErrMsg.getMessage());
          QLog.d("Q.devlock.AuthDevActivity", 2, paramWUserSigInfo.toString());
        }
      }
      if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
      {
        QQToast.makeText(this.a.getApplicationContext(), 1, paramErrMsg.getMessage(), 0).show(this.a.getTitleBarHeight());
        return;
      }
      QQToast.makeText(this.a.getApplicationContext(), 1, this.a.getString(2131888989), 0).show(this.a.getTitleBarHeight());
    }
  }
  
  public void onCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    boolean bool1 = this.a.isFinishing();
    boolean bool2 = true;
    if (bool1)
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, "OnCheckDevLockStatus activity is finished");
      return;
    }
    if ((paramInt == 0) && (paramDevlockInfo != null))
    {
      if (QLog.isColorLevel())
      {
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("OnCheckDevLockStatus ret = ");
        paramWUserSigInfo.append(paramInt);
        QLog.d("Q.devlock.AuthDevActivity", 2, paramWUserSigInfo.toString());
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
        QLog.d("Q.devlock.AuthDevActivity", 2, paramWUserSigInfo.toString());
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("DevlockInfo.ProtectIntro:");
        paramWUserSigInfo.append(paramDevlockInfo.ProtectIntro);
        paramWUserSigInfo.append("  info.MbGuideType:");
        paramWUserSigInfo.append(paramDevlockInfo.MbGuideType);
        QLog.d("Q.devlock.AuthDevActivity", 2, paramWUserSigInfo.toString());
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("DevlockInfo.MbGuideMsg:");
        paramWUserSigInfo.append(paramDevlockInfo.MbGuideMsg);
        QLog.d("Q.devlock.AuthDevActivity", 2, paramWUserSigInfo.toString());
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("DevlockInfo.MbGuideInfoType:");
        paramWUserSigInfo.append(paramDevlockInfo.MbGuideInfoType);
        QLog.d("Q.devlock.AuthDevActivity", 2, paramWUserSigInfo.toString());
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("DevlockInfo.MbGuideInfo:");
        paramWUserSigInfo.append(paramDevlockInfo.MbGuideInfo);
        QLog.d("Q.devlock.AuthDevActivity", 2, paramWUserSigInfo.toString());
      }
      DevlockPhoneStatus.a().a(paramDevlockInfo.TransferInfo);
      AuthDevActivity.access$3802(this.a, paramDevlockInfo);
      paramWUserSigInfo = this.a;
      if (AuthDevActivity.access$3800(paramWUserSigInfo).DevSetup == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      AuthDevActivity.access$1002(paramWUserSigInfo, bool1);
      paramWUserSigInfo = this.a;
      if (AuthDevActivity.access$3800(paramWUserSigInfo).AllowSet == 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      AuthDevActivity.access$3902(paramWUserSigInfo, bool1);
      AuthDevActivity.access$4000(this.a);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramWUserSigInfo = new StringBuilder();
      paramWUserSigInfo.append("OnCheckDevLockStatus ret = ");
      paramWUserSigInfo.append(paramInt);
      QLog.d("Q.devlock.AuthDevActivity", 2, paramWUserSigInfo.toString());
      if (paramErrMsg != null)
      {
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("OnCheckDevLockStatus errMsg:");
        paramWUserSigInfo.append(paramErrMsg.getMessage());
        QLog.d("Q.devlock.AuthDevActivity", 2, paramWUserSigInfo.toString());
      }
      if (paramDevlockInfo == null) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCheckDevLockStatus DevlockInfo is null");
      }
    }
    AuthDevActivity.access$4100(this.a);
    paramDevlockInfo = this.a.getString(2131888980);
    paramWUserSigInfo = paramDevlockInfo;
    if (paramErrMsg != null)
    {
      paramWUserSigInfo = paramDevlockInfo;
      if (!TextUtils.isEmpty(paramErrMsg.getMessage())) {
        paramWUserSigInfo = paramErrMsg.getMessage();
      }
    }
    QQToast.makeText(this.a.getApplicationContext(), paramWUserSigInfo, 0).show(this.a.getTitleBarHeight());
  }
  
  public void onCloseDevLock(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.a.isFinishing()) {
      return;
    }
    AuthDevActivity.access$1902(this.a, true);
    AuthDevActivity.access$2000(this.a);
    QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "OnCloseDevLock response , ret is ", Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      paramWUserSigInfo = (WtloginManager)AuthDevActivity.access$3000(this.a).getManager(1);
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.refreshMemorySig();
      }
      AuthDevActivity.access$200(this.a).setOnCheckedChangeListener(null);
      AuthDevActivity.access$200(this.a).setChecked(false);
      AuthDevActivity.access$200(this.a).setOnCheckedChangeListener(AuthDevActivity.access$2300(this.a));
      AuthDevActivity.access$000(this.a).setVisibility(8);
      AuthDevActivity.access$3100(this.a).setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCloseDevLock.success");
      }
      AuthDevActivity.access$1002(this.a, false);
      AuthDevActivity.access$3200(this.a).setVisibility(8);
      paramWUserSigInfo = AuthDevActivity.access$1300(this.a);
      paramErrMsg = AuthDevActivity.access$3300(this.a);
      AuthDevActivity localAuthDevActivity = this.a;
      paramWUserSigInfo.setLocalDevlockStatus(paramErrMsg, localAuthDevActivity, AuthDevActivity.access$3400(localAuthDevActivity).getCurrentAccountUin(), false);
      QQToast.makeText(this.a.getApplicationContext(), 2, this.a.getString(2131888958), 0).show(this.a.getTitleBarHeight());
      paramWUserSigInfo = this.a;
      paramWUserSigInfo = AuthDevActivity.access$2900(paramWUserSigInfo, AuthDevActivity.access$1300(paramWUserSigInfo).getLoginInfoActivity());
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.obtainMessage(20140331, 0, 0).sendToTarget();
      }
      AuthDevActivity.access$902(this.a, null);
      paramWUserSigInfo = this.a;
      AuthDevActivity.access$3500(paramWUserSigInfo, AuthDevActivity.access$900(paramWUserSigInfo));
      if (AuthDevActivity.access$3600(this.a)) {
        AuthDevActivity.access$3700(this.a);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("OnCloseDevLock.fail ret=");
        paramWUserSigInfo.append(paramInt);
        QLog.d("Q.devlock.AuthDevActivity", 2, paramWUserSigInfo.toString());
        if (paramErrMsg != null)
        {
          paramWUserSigInfo = new StringBuilder();
          paramWUserSigInfo.append("OnCloseDevLock.fail errMsg=");
          paramWUserSigInfo.append(paramErrMsg.getMessage());
          QLog.d("Q.devlock.AuthDevActivity", 2, paramWUserSigInfo.toString());
        }
      }
      if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
      {
        QQToast.makeText(this.a.getApplicationContext(), 1, paramErrMsg.getMessage(), 0).show(this.a.getTitleBarHeight());
        return;
      }
      QQToast.makeText(this.a.getApplicationContext(), 1, this.a.getString(2131888957), 0).show(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity.6
 * JD-Core Version:    0.7.0.1
 */