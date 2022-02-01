package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.widget.TextView;

class LoginVerifyCodeActivity$1
  implements Runnable
{
  LoginVerifyCodeActivity$1(LoginVerifyCodeActivity paramLoginVerifyCodeActivity) {}
  
  public void run()
  {
    if ((LoginVerifyCodeActivity.a(this.this$0) == 1) || (this.this$0.isFinishing()))
    {
      LoginVerifyCodeActivity.a(this.this$0).setText(2131716478);
      LoginVerifyCodeActivity.a(this.this$0).setEnabled(true);
      LoginVerifyCodeActivity.a(this.this$0).setClickable(true);
      return;
    }
    LoginVerifyCodeActivity.b(this.this$0);
    LoginVerifyCodeActivity.a(this.this$0).setText(this.this$0.getString(2131716478) + "(" + LoginVerifyCodeActivity.a(this.this$0) + ")");
    this.this$0.a.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity.1
 * JD-Core Version:    0.7.0.1
 */