package com.tencent.mobileqq.activity.registerGuideLogin;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

class LoginView$15
  implements Runnable
{
  LoginView$15(LoginView paramLoginView, String paramString, QQProgressDialog paramQQProgressDialog) {}
  
  public void run()
  {
    LoginView.a(this.this$0, this.a, false);
    if (this.this$0.b != null) {
      this.this$0.b.runOnUiThread(new LoginView.15.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.15
 * JD-Core Version:    0.7.0.1
 */