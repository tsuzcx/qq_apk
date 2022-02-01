package com.tencent.mobileqq.activity.registerGuideLogin;

import android.widget.Button;
import com.tencent.qphone.base.util.QLog;

class LoginView$13
  implements Runnable
{
  LoginView$13(LoginView paramLoginView) {}
  
  public void run()
  {
    QLog.d("LoginActivity.LoginView", 1, new Object[] { "onClick findPass valid=", Boolean.valueOf(this.this$0.m()) });
    if (this.this$0.m()) {
      LoginView.d(this.this$0).setClickable(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.13
 * JD-Core Version:    0.7.0.1
 */