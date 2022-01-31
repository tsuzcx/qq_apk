package com.tencent.mobileqq.activity.registerGuideLogin;

import android.view.View;
import com.tencent.qphone.base.util.QLog;

class LoginView$1
  implements Runnable
{
  LoginView$1(LoginView paramLoginView) {}
  
  public void run()
  {
    int[] arrayOfInt = new int[2];
    this.this$0.h.getLocationOnScreen(arrayOfInt);
    LoginView localLoginView = this.this$0;
    int i = this.this$0.b.getHeight();
    LoginView.a(localLoginView, arrayOfInt[1] + i - (int)(LoginView.a(this.this$0) * 7.0F + 0.5F));
    QLog.d("LoginActivity.LoginView", 2, "down bottomLine" + LoginView.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.1
 * JD-Core Version:    0.7.0.1
 */