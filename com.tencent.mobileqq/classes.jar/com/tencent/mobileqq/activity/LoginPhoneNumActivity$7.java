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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnCheckSMSVerifyLoginAccount appid=");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" subAppid=");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(" countryCode=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" mobile=");
      localStringBuilder.append(PhoneCodeUtils.a(paramString2));
      QLog.d("LoginPhoneNumActivity", 2, localStringBuilder.toString());
      paramString1 = new StringBuilder();
      paramString1.append("OnCheckSMSVerifyLoginAccount msg=");
      paramString1.append(paramString3);
      paramString1.append(" msgCnt=");
      paramString1.append(paramInt1);
      paramString1.append(" timeLimit=");
      paramString1.append(paramInt2);
      paramString1.append(" ret=");
      paramString1.append(paramInt3);
      QLog.d("LoginPhoneNumActivity", 2, paramString1.toString());
      if (paramErrMsg != null)
      {
        paramString1 = new StringBuilder();
        paramString1.append("OnCheckSMSVerifyLoginAccount errMsg=");
        paramString1.append(paramErrMsg.getMessage());
        QLog.d("LoginPhoneNumActivity", 2, paramString1.toString());
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
      paramString2 = this.a;
      paramString2.showDialog(paramString2.getString(2131691979), paramString1);
    }
    else
    {
      this.a.notifyToast(2131718220, 1);
    }
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = this.a.getString(2131718220);
    }
    ReportController.a(LoginPhoneNumActivity.access$400(this.a), "dc00898", "", LoginPhoneNumActivity.access$500(this.a), "0X800B107", "0X800B107", LoginPhoneNumActivity.access$600(this.a), 0, "", "", paramString2, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginPhoneNumActivity.7
 * JD-Core Version:    0.7.0.1
 */