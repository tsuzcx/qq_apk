package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.widget.TextView;

class LoginVerifyCodeActivity2$2
  implements Runnable
{
  LoginVerifyCodeActivity2$2(LoginVerifyCodeActivity2 paramLoginVerifyCodeActivity2) {}
  
  public void run()
  {
    if (LoginVerifyCodeActivity2.a(this.this$0) == 1)
    {
      LoginVerifyCodeActivity2.a(this.this$0).setText(2131716125);
      LoginVerifyCodeActivity2.a(this.this$0).setEnabled(true);
      LoginVerifyCodeActivity2.a(this.this$0).setClickable(true);
      return;
    }
    LoginVerifyCodeActivity2.b(this.this$0);
    LoginVerifyCodeActivity2.a(this.this$0).setText(this.this$0.getString(2131716125) + "(" + LoginVerifyCodeActivity2.a(this.this$0) + ")");
    this.this$0.b.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity2.2
 * JD-Core Version:    0.7.0.1
 */