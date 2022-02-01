package com.tencent.mobileqq.activity;

import android.os.Message;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.AccountManager;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class AuthDevActivity$8
  extends WtloginObserver
{
  AuthDevActivity$8(AuthDevActivity paramAuthDevActivity) {}
  
  public void onCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.a.isFinishing()) {}
    do
    {
      return;
      AuthDevActivity.access$1902(this.a, true);
      AuthDevActivity.access$1800(this.a);
      QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "OnCheckDevLockSms result : ret is ", Integer.valueOf(paramInt) });
      if (paramInt != 0) {
        break;
      }
      paramWUserSigInfo = (AccountManager)this.a.app.getManager(0);
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.refreshDA2(this.a.app.getCurrentAccountUin(), null);
      }
      AuthDevActivity.access$200(this.a).setOnCheckedChangeListener(null);
      AuthDevActivity.access$200(this.a).setChecked(true);
      AuthDevActivity.access$200(this.a).setOnCheckedChangeListener(AuthDevActivity.access$100(this.a));
      paramWUserSigInfo = (SecSvcHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCheckDevLockSms.success");
      }
      AuthDevActivity.access$902(this.a, true);
      EquipmentLockImpl.a().a(this.a.app, this.a, this.a.app.getCurrentAccountUin(), true);
      AuthDevActivity.access$2002(this.a, true);
      QQToast.a(this.a.getApplicationContext(), 2, this.a.getString(2131692061), 0).b(this.a.getTitleBarHeight());
      AuthDevActivity.access$2100(this.a);
      paramWUserSigInfo = this.a.app.getHandler(LoginInfoActivity.class);
    } while (paramWUserSigInfo == null);
    paramWUserSigInfo.obtainMessage(20140331, 1, 0).sendToTarget();
    return;
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevActivity", 2, "OnCheckDevLockSms.fail ret=" + paramInt);
      if (paramErrMsg != null) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCheckDevLockSms.fail errMsg=" + paramErrMsg.getMessage());
      }
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      QQToast.a(this.a.getApplicationContext(), 1, paramErrMsg.getMessage(), 0).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 1, this.a.getString(2131692103), 0).b(this.a.getTitleBarHeight());
  }
  
  public void onCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    boolean bool2 = true;
    if (this.a.isFinishing())
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, "OnCheckDevLockStatus activity is finished");
      return;
    }
    if ((paramInt == 0) && (paramDevlockInfo != null))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCheckDevLockStatus ret = " + paramInt);
        QLog.d("Q.devlock.AuthDevActivity", 2, "DevlockInfo devSetup:" + paramDevlockInfo.DevSetup + " countryCode:" + paramDevlockInfo.CountryCode + " mobile:" + paramDevlockInfo.Mobile + " MbItemSmsCodeStatus:" + paramDevlockInfo.MbItemSmsCodeStatus + " TimeLimit:" + paramDevlockInfo.TimeLimit + " AvailableMsgCount:" + paramDevlockInfo.AvailableMsgCount + " AllowSet:" + paramDevlockInfo.AllowSet);
        QLog.d("Q.devlock.AuthDevActivity", 2, "DevlockInfo.ProtectIntro:" + paramDevlockInfo.ProtectIntro + "  info.MbGuideType:" + paramDevlockInfo.MbGuideType);
        QLog.d("Q.devlock.AuthDevActivity", 2, "DevlockInfo.MbGuideMsg:" + paramDevlockInfo.MbGuideMsg);
        QLog.d("Q.devlock.AuthDevActivity", 2, "DevlockInfo.MbGuideInfoType:" + paramDevlockInfo.MbGuideInfoType);
        QLog.d("Q.devlock.AuthDevActivity", 2, "DevlockInfo.MbGuideInfo:" + paramDevlockInfo.MbGuideInfo);
      }
      DevlockPhoneStatus.a().a(paramDevlockInfo.TransferInfo);
      AuthDevActivity.access$2502(this.a, paramDevlockInfo);
      paramWUserSigInfo = this.a;
      if (AuthDevActivity.access$2500(this.a).DevSetup == 1)
      {
        bool1 = true;
        AuthDevActivity.access$902(paramWUserSigInfo, bool1);
        paramWUserSigInfo = this.a;
        if (AuthDevActivity.access$2500(this.a).AllowSet != 1) {
          break label378;
        }
      }
      label378:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        AuthDevActivity.access$2602(paramWUserSigInfo, bool1);
        AuthDevActivity.access$2700(this.a);
        return;
        bool1 = false;
        break;
      }
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevActivity", 2, "OnCheckDevLockStatus ret = " + paramInt);
      if (paramErrMsg != null) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCheckDevLockStatus errMsg:" + paramErrMsg.getMessage());
      }
      if (paramDevlockInfo == null) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCheckDevLockStatus DevlockInfo is null");
      }
    }
    AuthDevActivity.access$2800(this.a);
    paramDevlockInfo = this.a.getString(2131692094);
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
  
  public void onCloseDevLock(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.a.isFinishing()) {}
    do
    {
      return;
      AuthDevActivity.access$1902(this.a, true);
      AuthDevActivity.access$1800(this.a);
      QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "OnCloseDevLock response , ret is ", Integer.valueOf(paramInt) });
      if (paramInt != 0) {
        break;
      }
      paramWUserSigInfo = (WtloginManager)this.a.app.getManager(1);
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.refreshMemorySig();
      }
      AuthDevActivity.access$200(this.a).setOnCheckedChangeListener(null);
      AuthDevActivity.access$200(this.a).setChecked(false);
      AuthDevActivity.access$200(this.a).setOnCheckedChangeListener(AuthDevActivity.access$100(this.a));
      AuthDevActivity.access$000(this.a).setVisibility(8);
      AuthDevActivity.access$2200(this.a).setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCloseDevLock.success");
      }
      AuthDevActivity.access$902(this.a, false);
      AuthDevActivity.access$1400(this.a).setVisibility(8);
      EquipmentLockImpl.a().a(this.a.app, this.a, this.a.app.getCurrentAccountUin(), false);
      QQToast.a(this.a.getApplicationContext(), 2, this.a.getString(2131692072), 0).b(this.a.getTitleBarHeight());
      paramWUserSigInfo = this.a.app.getHandler(LoginInfoActivity.class);
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.obtainMessage(20140331, 0, 0).sendToTarget();
      }
      AuthDevActivity.access$802(this.a, null);
      AuthDevActivity.access$1600(this.a, AuthDevActivity.access$800(this.a));
    } while (!AuthDevActivity.access$2300(this.a));
    AuthDevActivity.access$2400(this.a);
    return;
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevActivity", 2, "OnCloseDevLock.fail ret=" + paramInt);
      if (paramErrMsg != null) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCloseDevLock.fail errMsg=" + paramErrMsg.getMessage());
      }
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      QQToast.a(this.a.getApplicationContext(), 1, paramErrMsg.getMessage(), 0).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 1, this.a.getString(2131692071), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity.8
 * JD-Core Version:    0.7.0.1
 */