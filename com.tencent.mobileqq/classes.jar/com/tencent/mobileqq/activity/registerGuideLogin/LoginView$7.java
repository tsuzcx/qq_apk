package com.tencent.mobileqq.activity.registerGuideLogin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.loginregister.LoginProxy;
import com.tencent.qphone.base.util.QLog;

class LoginView$7
  extends BroadcastReceiver
{
  LoginView$7(LoginView paramLoginView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.d("LoginActivity.LoginView", 1, "onReceive action=" + paramIntent.getAction());
    if ("mqq.intent.action.QRCODE_LOGIN_FINISH".equals(paramIntent.getAction()))
    {
      LoginView.a(this.a, 1, "0X800BA19");
      LoginView.a(this.a).a(this.a.getActivity(), paramIntent.getStringExtra("param_qr_code_url"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.7
 * JD-Core Version:    0.7.0.1
 */