package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.loginregister.SubAccountProxy;
import com.tencent.mobileqq.loginregister.SubSmsLoginErrorInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.VerifyCodeView;
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
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("OnGetStViaSMSVerifyLogin  userAccount = ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" ret=");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.d("LoginVerifyCodeActivity", 2, ((StringBuilder)localObject1).toString());
      if (paramErrMsg != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("OnGetStViaSMSVerifyLogin  errMsg = ");
        ((StringBuilder)localObject1).append(paramErrMsg.getMessage());
        QLog.d("LoginVerifyCodeActivity", 2, ((StringBuilder)localObject1).toString());
      }
    }
    this.a.closeDialog();
    if (paramInt2 == 0)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("OnGetStViaSMSVerifyLogin  login success ret =  ");
        paramArrayOfByte.append(paramInt2);
        QLog.d("LoginVerifyCodeActivity", 2, paramArrayOfByte.toString());
      }
      paramArrayOfByte = this.a.getIntent();
      paramErrMsg = paramArrayOfByte.getStringExtra("entrance");
      if ((!paramArrayOfByte.getBooleanExtra("login_from_account_change", false)) && (!"fromLogin".equals(paramErrMsg)))
      {
        paramString = (ILoginRegisterApi)QRoute.api(ILoginRegisterApi.class);
        paramString = LoginUtils.a(LoginVerifyCodeActivity.c(this.a), paramString.getLoginPhoneNumActivityClass());
        if (paramString != null) {
          paramString.sendEmptyMessage(2015);
        }
      }
      else
      {
        paramArrayOfByte = new Intent();
        paramArrayOfByte.putExtra("last_account", paramString);
        this.a.setResult(-1, paramArrayOfByte);
      }
      ReportController.a(LoginVerifyCodeActivity.d(this.a), "dc00898", "", LoginVerifyCodeActivity.a(this.a), "0X800B10C", "0X800B10C", LoginVerifyCodeActivity.c(this.a), 0, "", "", "", "");
      this.a.finish();
      return;
    }
    if (paramInt2 == -20160326)
    {
      this.a.finish();
      return;
    }
    if (paramInt2 == 2008)
    {
      this.a.notifyToast(2131692995, 0);
      this.a.finish();
      return;
    }
    String str = null;
    Object localObject2;
    if (paramErrMsg != null)
    {
      localObject2 = paramErrMsg.getMessage();
      localObject1 = localObject2;
      if (paramErrMsg.getType() == 1)
      {
        str = paramErrMsg.getOtherinfo();
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = null;
    }
    if (!TextUtils.isEmpty(str))
    {
      paramErrMsg = new Intent();
      paramErrMsg.putExtra("type", 8);
      if (paramInt2 == 40)
      {
        paramErrMsg.putExtra("msg", (String)localObject1);
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" ");
        ((StringBuilder)localObject2).append(str);
        paramErrMsg.putExtra("msg", ((StringBuilder)localObject2).toString());
      }
      paramErrMsg.putExtra("loginalias", paramString);
      paramErrMsg.putExtra("loginret", paramInt2);
      paramErrMsg.putExtra("expiredSig", paramArrayOfByte);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("LoginVerifyCodeActivity", 4, "OnGetStViaSMSVerifyLogin, goto Notification");
        }
        paramErrMsg.putExtra("lh_is_from_login_verify_code", true);
        LoginUtils.a(this.a, paramErrMsg, "/base/notification", 1);
        return;
      }
      LoginUtils.a(this.a, paramErrMsg, "/base/notification");
      return;
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      this.a.notifyToast(2131718220, 1);
    } else {
      this.a.notifyToast((String)localObject1, 0);
    }
    paramString = (String)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString = this.a.getString(2131718220);
    }
    ReportController.a(LoginVerifyCodeActivity.e(this.a), "dc00898", "", LoginVerifyCodeActivity.a(this.a), "0X800B10B", "0X800B10B", LoginVerifyCodeActivity.c(this.a), 0, "", "", paramString, "");
    if (paramInt2 == 155) {
      this.a.finish();
    }
  }
  
  public void onGetSubaccountStViaSMSVerifyLogin(String paramString1, String paramString2, long paramLong1, int paramInt1, long paramLong2, int paramInt2, ErrMsg paramErrMsg)
  {
    paramString1 = new SubSmsLoginErrorInfo(paramString1, paramString2, paramLong1, paramInt1, paramLong2, paramInt2, paramErrMsg);
    paramString2 = LoginVerifyCodeActivity.a(this.a);
    paramErrMsg = this.a;
    paramString2.a(paramErrMsg, paramString1, paramErrMsg);
  }
  
  public void onRefreshSMSVerifyLoginAccount(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnRefreshSMSVerifyLoginAccount.mobile=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" msg=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" timeLimit=");
      localStringBuilder.append(paramInt2);
      QLog.d("LoginVerifyCodeActivity", 2, localStringBuilder.toString());
      paramString1 = new StringBuilder();
      paramString1.append("OnRefreshSMSVerifyLoginAccount.ret=");
      paramString1.append(paramInt3);
      QLog.d("LoginVerifyCodeActivity", 2, paramString1.toString());
      if (paramErrMsg != null)
      {
        paramString1 = new StringBuilder();
        paramString1.append("OnRefreshSMSVerifyLoginAccount.errMsg=");
        paramString1.append(paramErrMsg);
        QLog.d("LoginVerifyCodeActivity", 2, paramString1.toString());
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
      if (TextUtils.isEmpty(paramString1)) {
        this.a.notifyToast(2131718220, 1);
      } else {
        this.a.notifyToast(paramString1, 0);
      }
      if (paramInt3 == 155) {
        this.a.finish();
      }
      paramString2 = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        paramString2 = this.a.getString(2131718220);
      }
      ReportController.a(LoginVerifyCodeActivity.a(this.a), "dc00898", "", LoginVerifyCodeActivity.a(this.a), "0X800B10B", "0X800B10B", LoginVerifyCodeActivity.c(this.a), 0, "", "", paramString2, "");
      return;
    }
    LoginVerifyCodeActivity.a(this.a, 60);
  }
  
  public void onVerifySMSVerifyLoginAccount(String paramString1, String paramString2, int paramInt, WUserSigInfo paramWUserSigInfo, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnVerifySMSVerifyLoginAccount mobile=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" msgCode=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" ret=");
      localStringBuilder.append(paramInt);
      QLog.d("LoginVerifyCodeActivity", 2, localStringBuilder.toString());
      if (paramErrMsg != null)
      {
        paramString1 = new StringBuilder();
        paramString1.append("OnVerifySMSVerifyLoginAccount errMsg=");
        paramString1.append(paramErrMsg.getMessage());
        QLog.d("LoginVerifyCodeActivity", 2, paramString1.toString());
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
      LoginVerifyCodeActivity.a(this.a).a();
      if (TextUtils.isEmpty(paramString1)) {
        this.a.notifyToast(2131718220, 1);
      } else {
        this.a.notifyToast(paramString1, 1);
      }
      if (paramInt == 155) {
        this.a.finish();
      }
      paramString2 = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        paramString2 = this.a.getString(2131718220);
      }
      ReportController.a(LoginVerifyCodeActivity.b(this.a), "dc00898", "", LoginVerifyCodeActivity.a(this.a), "0X800B10B", "0X800B10B", LoginVerifyCodeActivity.c(this.a), 0, "", "", paramString2, "");
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity.2
 * JD-Core Version:    0.7.0.1
 */