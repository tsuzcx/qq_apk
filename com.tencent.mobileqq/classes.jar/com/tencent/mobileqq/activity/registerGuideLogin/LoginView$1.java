package com.tencent.mobileqq.activity.registerGuideLogin;

import android.view.View;
import com.tencent.qphone.base.util.QLog;

class LoginView$1
  implements Runnable
{
  LoginView$1(LoginView paramLoginView) {}
  
  public void run()
  {
    Object localObject = new int[2];
    this.this$0.u.getLocationOnScreen((int[])localObject);
    LoginView localLoginView = this.this$0;
    LoginView.a(localLoginView, localLoginView.l.getHeight() + localObject[1] - (int)(LoginView.a(this.this$0) * 7.0F + 0.5F));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("down bottomLine");
    ((StringBuilder)localObject).append(LoginView.b(this.this$0));
    QLog.d("LoginActivity.LoginView", 2, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.1
 * JD-Core Version:    0.7.0.1
 */