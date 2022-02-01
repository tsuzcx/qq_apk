package com.tencent.mobileqq.activity.registerGuideLogin;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

class LoginView$15$1
  implements Runnable
{
  LoginView$15$1(LoginView.15 param15) {}
  
  public void run()
  {
    if ((this.a.a != null) && (this.a.a.isShowing()) && (!this.a.this$0.a.isFinishing()))
    {
      this.a.a.dismiss();
      this.a.a.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.15.1
 * JD-Core Version:    0.7.0.1
 */