package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class DevlockPushActivity$2
  extends WtloginObserver
{
  DevlockPushActivity$2(DevlockPushActivity paramDevlockPushActivity) {}
  
  public void onCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (!this.a.isResume())
    {
      this.a.b();
      return;
    }
    if (((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) && (paramInt == 0) && (paramDevlockInfo != null))
    {
      this.a.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = paramDevlockInfo;
      DevlockPhoneStatus.a().a(this.a.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.TransferInfo);
      return;
    }
    this.a.b();
    if ((paramInt == 0) && (paramDevlockInfo != null))
    {
      if (QLog.isColorLevel())
      {
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("OnCheckDevLockStatus ret = ");
        paramWUserSigInfo.append(paramInt);
        QLog.d("Q.devlock.DevlockPushActivity", 2, paramWUserSigInfo.toString());
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
        QLog.d("Q.devlock.DevlockPushActivity", 2, paramWUserSigInfo.toString());
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("DevlockInfo.MbGuideInfoType:");
        paramWUserSigInfo.append(paramDevlockInfo.MbGuideInfoType);
        QLog.d("Q.devlock.DevlockPushActivity", 2, paramWUserSigInfo.toString());
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("DevlockInfo.MbGuideInfo:");
        paramWUserSigInfo.append(paramDevlockInfo.MbGuideInfo);
        QLog.d("Q.devlock.DevlockPushActivity", 2, paramWUserSigInfo.toString());
      }
      this.a.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = paramDevlockInfo;
      DevlockPhoneStatus.a().a(this.a.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.TransferInfo);
      paramWUserSigInfo = this.a;
      paramWUserSigInfo.a(paramWUserSigInfo.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramWUserSigInfo = new StringBuilder();
      paramWUserSigInfo.append("OnCheckDevLockStatus ret = ");
      paramWUserSigInfo.append(paramInt);
      QLog.d("Q.devlock.DevlockPushActivity", 2, paramWUserSigInfo.toString());
      if (paramErrMsg != null)
      {
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("OnCheckDevLockStatus errMsg:");
        paramWUserSigInfo.append(paramErrMsg.getMessage());
        QLog.d("Q.devlock.DevlockPushActivity", 2, paramWUserSigInfo.toString());
      }
      if (paramDevlockInfo == null) {
        QLog.d("Q.devlock.DevlockPushActivity", 2, "OnCheckDevLockStatus DevlockInfo is null");
      }
    }
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
 * Qualified Name:     com.tencent.mobileqq.activity.DevlockPushActivity.2
 * JD-Core Version:    0.7.0.1
 */