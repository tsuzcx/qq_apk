package com.tencent.mobileqq.activity.registerGuideLogin;

import com.tencent.qphone.base.util.QLog;

class LoginAnimBtnView$1
  implements Runnable
{
  LoginAnimBtnView$1(LoginAnimBtnView paramLoginAnimBtnView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LoginAnimBtnView", 2, "mUpdateRunnable isEnabled:" + this.this$0.isEnabled() + "  mLottieDrawable:" + LoginAnimBtnView.a(this.this$0) + " mIsDestroyed:" + LoginAnimBtnView.a(this.this$0));
    }
    if (LoginAnimBtnView.a(this.this$0)) {
      return;
    }
    if (this.this$0.isEnabled())
    {
      if (LoginAnimBtnView.a(this.this$0) != null)
      {
        LoginAnimBtnView.a(this.this$0, true);
        LoginAnimBtnView.b(this.this$0, true);
        this.this$0.setBackgroundDrawable(LoginAnimBtnView.a(this.this$0));
        LoginAnimBtnView.a(this.this$0);
        return;
      }
      LoginAnimBtnView.b(this.this$0, false);
      this.this$0.setBackgroundColor(LoginAnimBtnView.a(this.this$0));
      return;
    }
    LoginAnimBtnView.b(this.this$0, false);
    this.this$0.setBackgroundColor(LoginAnimBtnView.b(this.this$0));
    LoginAnimBtnView.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginAnimBtnView.1
 * JD-Core Version:    0.7.0.1
 */