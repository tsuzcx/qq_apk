package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

class LoginPhoneNumActivity$7
  extends WtloginObserver
{
  LoginPhoneNumActivity$7(LoginPhoneNumActivity paramLoginPhoneNumActivity) {}
  
  public void onCheckSMSVerifyLoginAccount(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("LoginPhoneNumActivity", 2, "OnCheckSMSVerifyLoginAccount appid=" + paramLong1 + " subAppid=" + paramLong2 + " countryCode=" + paramString1 + " mobile=" + PhoneCodeUtils.a(paramString2));
      QLog.d("LoginPhoneNumActivity", 2, "OnCheckSMSVerifyLoginAccount msg=" + paramString3 + " msgCnt=" + paramInt1 + " timeLimit=" + paramInt2 + " ret=" + paramInt3);
      if (paramErrMsg != null) {
        QLog.d("LoginPhoneNumActivity", 2, "OnCheckSMSVerifyLoginAccount errMsg=" + paramErrMsg.getMessage());
      }
    }
    this.a.closeDialog();
    if (this.a.isFinishing()) {
      return;
    }
    if (paramInt3 == 0)
    {
      this.a.go2next();
      return;
    }
    paramString1 = null;
    if (paramErrMsg != null) {
      paramString1 = paramErrMsg.getMessage();
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      this.a.showDialog(this.a.getString(2131692060), paramString1);
      if (!TextUtils.isEmpty(paramString1)) {
        break label299;
      }
      paramString1 = this.a.getString(2131718552);
    }
    label299:
    for (;;)
    {
      ReportController.a(LoginPhoneNumActivity.access$500(this.a), "dc00898", "", LoginPhoneNumActivity.access$600(this.a), "0X800B107", "0X800B107", LoginPhoneNumActivity.access$700(this.a), 0, "", "", paramString1, "");
      return;
      this.a.notifyToast(2131718552, 1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginPhoneNumActivity.7
 * JD-Core Version:    0.7.0.1
 */