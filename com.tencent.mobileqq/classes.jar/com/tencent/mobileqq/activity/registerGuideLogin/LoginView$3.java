package com.tencent.mobileqq.activity.registerGuideLogin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class LoginView$3
  extends BroadcastReceiver
{
  LoginView$3(LoginView paramLoginView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.d("LoginActivity.LoginView", 1, "AutoLoginReceiver onReceive");
    LoginView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.3
 * JD-Core Version:    0.7.0.1
 */