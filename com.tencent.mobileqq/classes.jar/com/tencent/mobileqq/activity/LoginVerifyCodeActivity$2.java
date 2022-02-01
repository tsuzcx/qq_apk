package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.loginregister.SubAccountProxy;
import com.tencent.mobileqq.loginregister.SubSmsLoginErrorInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class LoginVerifyCodeActivity$2
  extends WtloginObserver
{
  LoginVerifyCodeActivity$2(LoginVerifyCodeActivity paramLoginVerifyCodeActivity) {}
  
  public void onGetStViaSMSVerifyLogin(String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("LoginVerifyCodeActivity", 2, "OnGetStViaSMSVerifyLogin  userAccount = " + paramString + " ret=" + paramInt2);
      if (paramErrMsg != null) {
        QLog.d("LoginVerifyCodeActivity", 2, "OnGetStViaSMSVerifyLogin  errMsg = " + paramErrMsg.getMessage());
      }
    }
    this.a.closeDialog();
    if (paramInt2 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "OnGetStViaSMSVerifyLogin  login success ret =  " + paramInt2);
      }
      paramArrayOfByte = this.a.getIntent();
      paramErrMsg = paramArrayOfByte.getStringExtra("entrance");
      if ((paramArrayOfByte.getBooleanExtra("login_from_account_change", false)) || ("fromLogin".equals(paramErrMsg)))
      {
        paramArrayOfByte = new Intent();
        paramArrayOfByte.putExtra("last_account", paramString);
        this.a.setResult(-1, paramArrayOfByte);
      }
      for (;;)
      {
        ReportController.a(LoginVerifyCodeActivity.d(this.a), "dc00898", "", LoginVerifyCodeActivity.a(this.a), "0X800B10C", "0X800B10C", LoginVerifyCodeActivity.c(this.a), 0, "", "", "", "");
        this.a.finish();
        return;
        paramString = (ILoginRegisterApi)QRoute.api(ILoginRegisterApi.class);
        paramString = LoginUtils.a(LoginVerifyCodeActivity.c(this.a), paramString.getLoginPhoneNumActivityClass());
        if (paramString != null) {
          paramString.sendEmptyMessage(2015);
        }
      }
    }
    if (paramInt2 == -20160326)
    {
      this.a.finish();
      return;
    }
    if (paramInt2 == 2008)
    {
      this.a.notifyToast(2131693035, 0);
      this.a.finish();
      return;
    }
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = localObject3;
    if (paramErrMsg != null)
    {
      String str = paramErrMsg.getMessage();
      localObject2 = localObject3;
      localObject1 = str;
      if (paramErrMsg.getType() == 1)
      {
        localObject2 = paramErrMsg.getOtherinfo();
        localObject1 = str;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramErrMsg = new Intent();
      paramErrMsg.putExtra("type", 8);
      if (paramInt2 == 40) {
        paramErrMsg.putExtra("msg", localObject1);
      }
      for (;;)
      {
        paramErrMsg.putExtra("loginalias", paramString);
        paramErrMsg.putExtra("loginret", paramInt2);
        paramErrMsg.putExtra("expiredSig", paramArrayOfByte);
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
          break;
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("LoginVerifyCodeActivity", 4, "OnGetStViaSMSVerifyLogin, goto Notification");
        }
        paramErrMsg.putExtra("lh_is_from_login_verify_code", true);
        LoginUtils.a(this.a, paramErrMsg, "/base/notification", 1);
        return;
        paramErrMsg.putExtra("msg", localObject1 + " " + (String)localObject2);
      }
      LoginUtils.a(this.a, paramErrMsg, "/base/notification");
      return;
    }
    if (TextUtils.isEmpty(localObject1))
    {
      this.a.notifyToast(2131718552, 1);
      label553:
      if (!TextUtils.isEmpty(localObject1)) {
        break label640;
      }
    }
    label640:
    for (paramString = this.a.getString(2131718552);; paramString = localObject1)
    {
      ReportController.a(LoginVerifyCodeActivity.e(this.a), "dc00898", "", LoginVerifyCodeActivity.a(this.a), "0X800B10B", "0X800B10B", LoginVerifyCodeActivity.c(this.a), 0, "", "", paramString, "");
      if (paramInt2 != 155) {
        break;
      }
      this.a.finish();
      return;
      this.a.notifyToast(localObject1, 0);
      break label553;
    }
  }
  
  public void onGetSubaccountStViaSMSVerifyLogin(String paramString1, String paramString2, long paramLong1, int paramInt1, long paramLong2, int paramInt2, ErrMsg paramErrMsg)
  {
    paramString1 = new SubSmsLoginErrorInfo(paramString1, paramString2, paramLong1, paramInt1, paramLong2, paramInt2, paramErrMsg);
    LoginVerifyCodeActivity.a(this.a).a(this.a, paramString1, this.a);
  }
  
  public void onRefreshSMSVerifyLoginAccount(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("LoginVerifyCodeActivity", 2, "OnRefreshSMSVerifyLoginAccount.mobile=" + paramString1 + " msg=" + paramString2 + " timeLimit=" + paramInt2);
      QLog.d("LoginVerifyCodeActivity", 2, "OnRefreshSMSVerifyLoginAccount.ret=" + paramInt3);
      if (paramErrMsg != null) {
        QLog.d("LoginVerifyCodeActivity", 2, "OnRefreshSMSVerifyLoginAccount.errMsg=" + paramErrMsg);
      }
    }
    if (this.a.isFinishing()) {
      return;
    }
    this.a.closeDialog();
    if (paramInt3 != 0)
    {
      paramString1 = null;
      if (paramErrMsg != null) {
        paramString1 = paramErrMsg.getMessage();
      }
      if (TextUtils.isEmpty(paramString1))
      {
        this.a.notifyToast(2131718552, 1);
        if (paramInt3 == 155) {
          this.a.finish();
        }
        if (!TextUtils.isEmpty(paramString1)) {
          break label245;
        }
        paramString1 = this.a.getString(2131718552);
      }
      label245:
      for (;;)
      {
        ReportController.a(LoginVerifyCodeActivity.a(this.a), "dc00898", "", LoginVerifyCodeActivity.a(this.a), "0X800B10B", "0X800B10B", LoginVerifyCodeActivity.c(this.a), 0, "", "", paramString1, "");
        return;
        this.a.notifyToast(paramString1, 0);
        break;
      }
    }
    LoginVerifyCodeActivity.a(this.a, 60);
  }
  
  public void onVerifySMSVerifyLoginAccount(String paramString1, String paramString2, int paramInt, WUserSigInfo paramWUserSigInfo, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("LoginVerifyCodeActivity", 2, "OnVerifySMSVerifyLoginAccount mobile=" + paramString1 + " msgCode=" + paramString2 + " ret=" + paramInt);
      if (paramErrMsg != null) {
        QLog.d("LoginVerifyCodeActivity", 2, "OnVerifySMSVerifyLoginAccount errMsg=" + paramErrMsg.getMessage());
      }
    }
    if (this.a.isFinishing()) {
      return;
    }
    if (paramInt != 0)
    {
      this.a.closeDialog();
      paramString1 = null;
      if (paramErrMsg != null) {
        paramString1 = paramErrMsg.getMessage();
      }
      if (TextUtils.isEmpty(paramString1))
      {
        this.a.notifyToast(2131718552, 1);
        if (paramInt == 155) {
          this.a.finish();
        }
        if (!TextUtils.isEmpty(paramString1)) {
          break label222;
        }
        paramString1 = this.a.getString(2131718552);
      }
      label222:
      for (;;)
      {
        ReportController.a(LoginVerifyCodeActivity.b(this.a), "dc00898", "", LoginVerifyCodeActivity.a(this.a), "0X800B10B", "0X800B10B", LoginVerifyCodeActivity.c(this.a), 0, "", "", paramString1, "");
        return;
        this.a.notifyToast(paramString1, 0);
        break;
      }
    }
    if (LoginVerifyCodeActivity.a(this.a, paramWUserSigInfo))
    {
      LoginVerifyCodeActivity.a(this.a);
      return;
    }
    paramString1 = new Intent();
    paramString1.putExtra("key_mask_users", paramWUserSigInfo);
    this.a.setResult(-1, paramString1);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity.2
 * JD-Core Version:    0.7.0.1
 */