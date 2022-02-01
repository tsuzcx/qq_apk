package com.tencent.mobileqq.activity;

import agej;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.redtouch.RedTouch;

class LoginInfoActivity$3
  implements Runnable
{
  LoginInfoActivity$3(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void run()
  {
    LoginInfoActivity.a(this.this$0, new RedTouch(this.this$0, LoginInfoActivity.a(this.this$0)));
    LoginInfoActivity.a(this.this$0).a(53);
    int i = LoginInfoActivity.b(this.this$0).getTop();
    int j = LoginInfoActivity.a(this.this$0).getWidth();
    int k = LoginInfoActivity.b(this.this$0).getRight();
    LoginInfoActivity.a(this.this$0).c((int)agej.a(j - k - 10, this.this$0.getResources()));
    LoginInfoActivity.a(this.this$0).d((int)agej.a(i - 10, this.this$0.getResources()));
    LoginInfoActivity.a(this.this$0).a();
    LoginInfoActivity.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.3
 * JD-Core Version:    0.7.0.1
 */