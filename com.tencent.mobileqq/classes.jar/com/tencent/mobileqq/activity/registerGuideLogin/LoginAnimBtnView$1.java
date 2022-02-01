package com.tencent.mobileqq.activity.registerGuideLogin;

import com.tencent.qphone.base.util.QLog;

class LoginAnimBtnView$1
  implements Runnable
{
  LoginAnimBtnView$1(LoginAnimBtnView paramLoginAnimBtnView) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mUpdateRunnable isEnabled:");
      ((StringBuilder)localObject).append(this.this$0.isEnabled());
      ((StringBuilder)localObject).append("  mLottieDrawable:");
      ((StringBuilder)localObject).append(LoginAnimBtnView.a(this.this$0));
      ((StringBuilder)localObject).append(" mIsDestroyed:");
      ((StringBuilder)localObject).append(LoginAnimBtnView.b(this.this$0));
      QLog.i("LoginAnimBtnView", 2, ((StringBuilder)localObject).toString());
    }
    if (LoginAnimBtnView.b(this.this$0)) {
      return;
    }
    if (this.this$0.isEnabled())
    {
      if (LoginAnimBtnView.a(this.this$0) != null)
      {
        LoginAnimBtnView.a(this.this$0, true);
        LoginAnimBtnView.b(this.this$0, true);
        localObject = this.this$0;
        ((LoginAnimBtnView)localObject).setBackgroundDrawable(LoginAnimBtnView.a((LoginAnimBtnView)localObject));
        LoginAnimBtnView.c(this.this$0);
        return;
      }
      LoginAnimBtnView.b(this.this$0, false);
      localObject = this.this$0;
      ((LoginAnimBtnView)localObject).setBackgroundColor(LoginAnimBtnView.d((LoginAnimBtnView)localObject));
      return;
    }
    LoginAnimBtnView.b(this.this$0, false);
    Object localObject = this.this$0;
    ((LoginAnimBtnView)localObject).setBackgroundColor(LoginAnimBtnView.e((LoginAnimBtnView)localObject));
    LoginAnimBtnView.f(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginAnimBtnView.1
 * JD-Core Version:    0.7.0.1
 */