package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.widget.TextView;

class AuthDevVerifyCodeActivity$1
  implements Runnable
{
  AuthDevVerifyCodeActivity$1(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void run()
  {
    if (AuthDevVerifyCodeActivity.b <= 1)
    {
      AuthDevVerifyCodeActivity.a(this.this$0).setText(2131717544);
      AuthDevVerifyCodeActivity.a(this.this$0).setEnabled(true);
      AuthDevVerifyCodeActivity.a(this.this$0).setClickable(true);
      return;
    }
    AuthDevVerifyCodeActivity.b -= 1;
    AuthDevVerifyCodeActivity.a(this.this$0).setText(this.this$0.getString(2131717544) + "(" + AuthDevVerifyCodeActivity.b + ")");
    this.this$0.a.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity.1
 * JD-Core Version:    0.7.0.1
 */