package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.widget.TextView;

class LoginVerifyCodeActivity$1
  implements Runnable
{
  LoginVerifyCodeActivity$1(LoginVerifyCodeActivity paramLoginVerifyCodeActivity) {}
  
  public void run()
  {
    if ((LoginVerifyCodeActivity.a(this.this$0) != 1) && (!this.this$0.isFinishing()))
    {
      LoginVerifyCodeActivity.c(this.this$0);
      TextView localTextView = LoginVerifyCodeActivity.b(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.this$0.getString(2131914089));
      localStringBuilder.append(" (");
      localStringBuilder.append(LoginVerifyCodeActivity.a(this.this$0));
      localStringBuilder.append("s)");
      localTextView.setText(localStringBuilder.toString());
      this.this$0.handler.postDelayed(this, 1000L);
      return;
    }
    LoginVerifyCodeActivity.b(this.this$0).setText(2131914089);
    LoginVerifyCodeActivity.b(this.this$0).setTextColor(-11692801);
    LoginVerifyCodeActivity.b(this.this$0).setEnabled(true);
    LoginVerifyCodeActivity.b(this.this$0).setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity.1
 * JD-Core Version:    0.7.0.1
 */