package com.tencent.mobileqq.activity.registerGuideLogin;

import android.content.Intent;
import com.tencent.mobileqq.activity.NewAuthDevUgFragment;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.GatewayLoginNewDevHelper;
import com.tencent.mobileqq.util.PhoneNumQuickLoginManager;
import com.tencent.mobileqq.util.QuickLoginReporter;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.VerifyDevLockManagerImpl;
import mqq.bean.OnLoginByGatewayParam;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class LoginView$29
  extends WtloginObserver
{
  LoginView$29(LoginView paramLoginView) {}
  
  public void onException(String paramString, int paramInt)
  {
    if (paramInt == 4001) {
      LoginView.a(this.a, null);
    }
    PhoneNumQuickLoginManager.b("0X800B8D0");
    PhoneNumQuickLoginManager.a(this.a.b, LoginView.B(this.a));
    this.a.b(4);
    paramString = this.a;
    LoginView.c(paramString, paramString.getString(2131897203));
  }
  
  public void onLoginByGateway(int paramInt, OnLoginByGatewayParam paramOnLoginByGatewayParam)
  {
    int i = paramOnLoginByGatewayParam.seq;
    DevlockInfo localDevlockInfo = paramOnLoginByGatewayParam.info;
    ToServiceMsg localToServiceMsg = paramOnLoginByGatewayParam.to;
    WUserSigInfo localWUserSigInfo = paramOnLoginByGatewayParam.userSigInfo;
    String str2 = paramOnLoginByGatewayParam.uin;
    ErrMsg localErrMsg = paramOnLoginByGatewayParam.errMsg;
    String str1 = "null";
    if (localErrMsg == null) {
      paramOnLoginByGatewayParam = "null";
    } else {
      paramOnLoginByGatewayParam = localErrMsg.getMessage();
    }
    QLog.d("LoginActivity.LoginView", 1, new Object[] { "quickLoginByGateway response, ret : ", Integer.valueOf(paramInt), " errorMsg : ", paramOnLoginByGatewayParam });
    if (paramInt == 0)
    {
      LoginView.b(this.a, str2);
      PhoneNumQuickLoginManager.a(String.valueOf(2));
      PhoneNumQuickLoginManager.b("0X800B8D8");
      QuickLoginReporter.b(paramInt, "SUCCESS");
      return;
    }
    if (paramInt == 21)
    {
      PhoneNumQuickLoginManager.a(this.a.b);
      PhoneNumQuickLoginManager.b("0X800B8D6");
      i = 1;
    }
    else if (paramInt == 22)
    {
      PhoneNumQuickLoginManager.a(localWUserSigInfo, this.a.b, LoginView.B(this.a), LoginView.F(this.a));
      i = 4;
    }
    else if (paramInt == 160)
    {
      paramOnLoginByGatewayParam = this.a;
      LoginView.c(paramOnLoginByGatewayParam, paramOnLoginByGatewayParam.getString(2131897203));
      PhoneNumQuickLoginManager.a(this.a.b, LoginView.B(this.a));
      PhoneNumQuickLoginManager.b("0X800B8D0");
      i = 3;
    }
    else
    {
      if (paramInt == 224)
      {
        paramOnLoginByGatewayParam = (VerifyDevLockManagerImpl)this.a.a.getManager(7);
        if (paramOnLoginByGatewayParam != null) {
          paramOnLoginByGatewayParam.pullToServiceMsg(i, localToServiceMsg);
        }
        GatewayLoginNewDevHelper.a();
        paramOnLoginByGatewayParam = new Intent();
        paramOnLoginByGatewayParam.setFlags(268435456);
        paramOnLoginByGatewayParam.putExtra("DevlockInfo", localDevlockInfo);
        paramOnLoginByGatewayParam.putExtra("seq", i);
        paramOnLoginByGatewayParam.putExtra("uin", str2);
        paramOnLoginByGatewayParam.putExtra("from_login", true);
        paramOnLoginByGatewayParam.putExtra("from_phone_num_login", true);
        QPublicFragmentActivity.start(this.a.b, paramOnLoginByGatewayParam, NewAuthDevUgFragment.class);
        paramOnLoginByGatewayParam = this.a;
        paramOnLoginByGatewayParam.F = true;
        paramOnLoginByGatewayParam.b(4);
        return;
      }
      paramOnLoginByGatewayParam = this.a;
      LoginView.c(paramOnLoginByGatewayParam, paramOnLoginByGatewayParam.getString(2131897203));
      PhoneNumQuickLoginManager.a(this.a.b, LoginView.B(this.a));
      PhoneNumQuickLoginManager.b("0X800B8D0");
      i = 5;
    }
    if (localErrMsg == null) {
      paramOnLoginByGatewayParam = str1;
    } else {
      paramOnLoginByGatewayParam = localErrMsg.getMessage();
    }
    QuickLoginReporter.b(paramInt, paramOnLoginByGatewayParam);
    PhoneNumQuickLoginManager.a(String.valueOf(i));
    this.a.b(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.29
 * JD-Core Version:    0.7.0.1
 */