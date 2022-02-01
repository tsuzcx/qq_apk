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
    QLog.d("LoginPhoneNumActivity", 1, new Object[] { "OnCheckSMSVerifyLoginAccount appid=", Long.valueOf(paramLong1), " subAppid=", Long.valueOf(paramLong2), " countryCode=", paramString1, " mobile=", PhoneCodeUtils.a(paramString2) });
    QLog.d("LoginPhoneNumActivity", 1, new Object[] { "OnCheckSMSVerifyLoginAccount msg=", paramString3, " msgCnt=", Integer.valueOf(paramInt1), " timeLimit=", Integer.valueOf(paramInt2), " ret=", Integer.valueOf(paramInt3) });
    if (paramErrMsg != null)
    {
      paramString1 = new StringBuilder();
      paramString1.append("OnCheckSMSVerifyLoginAccount errMsg=");
      paramString1.append(paramErrMsg.getMessage());
      QLog.d("LoginPhoneNumActivity", 1, paramString1.toString());
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
      paramString2 = this.a;
      paramString2.showDialog(paramString2.getString(2131888946), paramString1);
    }
    else
    {
      this.a.notifyToast(2131915702, 1);
    }
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = this.a.getString(2131915702);
    }
    ReportController.a(LoginPhoneNumActivity.access$400(this.a), "dc00898", "", LoginPhoneNumActivity.access$500(this.a), "0X800B107", "0X800B107", this.a.getEntranceType(), 0, "", "", paramString2, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginPhoneNumActivity.7
 * JD-Core Version:    0.7.0.1
 */