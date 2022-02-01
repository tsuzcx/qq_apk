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
    PhoneNumQuickLoginManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, LoginView.b(this.a));
    LoginView.a(this.a, 4);
    LoginView.b(this.a, this.a.getString(2131699080));
  }
  
  public void onLoginByGateway(int paramInt, OnLoginByGatewayParam paramOnLoginByGatewayParam)
  {
    int i = paramOnLoginByGatewayParam.seq;
    DevlockInfo localDevlockInfo = paramOnLoginByGatewayParam.info;
    ToServiceMsg localToServiceMsg = paramOnLoginByGatewayParam.to;
    WUserSigInfo localWUserSigInfo = paramOnLoginByGatewayParam.userSigInfo;
    String str = paramOnLoginByGatewayParam.uin;
    ErrMsg localErrMsg = paramOnLoginByGatewayParam.errMsg;
    if (localErrMsg == null) {}
    for (paramOnLoginByGatewayParam = "null";; paramOnLoginByGatewayParam = localErrMsg.getMessage())
    {
      QLog.d("LoginActivity.LoginView", 1, new Object[] { "quickLoginByGateway response, ret : ", Integer.valueOf(paramInt), " errorMsg : ", paramOnLoginByGatewayParam });
      if (paramInt != 0) {
        break;
      }
      LoginView.a(this.a, str);
      PhoneNumQuickLoginManager.a(String.valueOf(2));
      PhoneNumQuickLoginManager.b("0X800B8D8");
      QuickLoginReporter.b(paramInt, "SUCCESS");
      return;
    }
    if (paramInt == 21)
    {
      PhoneNumQuickLoginManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      PhoneNumQuickLoginManager.b("0X800B8D6");
      i = 1;
      if (localErrMsg != null) {
        break label422;
      }
    }
    label422:
    for (paramOnLoginByGatewayParam = "null";; paramOnLoginByGatewayParam = localErrMsg.getMessage())
    {
      QuickLoginReporter.b(paramInt, paramOnLoginByGatewayParam);
      PhoneNumQuickLoginManager.a(String.valueOf(i));
      LoginView.a(this.a, 4);
      return;
      if (paramInt == 22)
      {
        PhoneNumQuickLoginManager.a(localWUserSigInfo, this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, LoginView.b(this.a), LoginView.k(this.a));
        i = 4;
        break;
      }
      if (paramInt == 160)
      {
        LoginView.b(this.a, this.a.getString(2131699080));
        PhoneNumQuickLoginManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, LoginView.b(this.a));
        PhoneNumQuickLoginManager.b("0X800B8D0");
        i = 3;
        break;
      }
      if (paramInt == 224)
      {
        paramOnLoginByGatewayParam = (VerifyDevLockManagerImpl)this.a.jdField_a_of_type_MqqAppAppRuntime.getManager(7);
        if (paramOnLoginByGatewayParam != null) {
          paramOnLoginByGatewayParam.pullToServiceMsg(i, localToServiceMsg);
        }
        GatewayLoginNewDevHelper.a();
        paramOnLoginByGatewayParam = new Intent();
        paramOnLoginByGatewayParam.setFlags(268435456);
        paramOnLoginByGatewayParam.putExtra("DevlockInfo", localDevlockInfo);
        paramOnLoginByGatewayParam.putExtra("seq", i);
        paramOnLoginByGatewayParam.putExtra("uin", str);
        paramOnLoginByGatewayParam.putExtra("from_login", true);
        paramOnLoginByGatewayParam.putExtra("from_phone_num_login", true);
        QPublicFragmentActivity.a(this.a.getActivity(), paramOnLoginByGatewayParam, NewAuthDevUgFragment.class);
        LoginView.h(this.a, true);
        LoginView.a(this.a, 4);
        return;
      }
      LoginView.b(this.a, this.a.getString(2131699080));
      PhoneNumQuickLoginManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, LoginView.b(this.a));
      PhoneNumQuickLoginManager.b("0X800B8D0");
      i = 5;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.29
 * JD-Core Version:    0.7.0.1
 */