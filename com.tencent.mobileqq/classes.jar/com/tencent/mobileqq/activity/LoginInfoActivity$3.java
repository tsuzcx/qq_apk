package com.tencent.mobileqq.activity;

import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.tianshu.ui.RedTouch;

class LoginInfoActivity$3
  implements Runnable
{
  LoginInfoActivity$3(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void run()
  {
    LoginInfoActivity.access$1202(this.this$0, new RedTouch(this.this$0, LoginInfoActivity.access$1300(this.this$0)));
    LoginInfoActivity.access$1200(this.this$0).b(53);
    int i = LoginInfoActivity.access$1400(this.this$0).getTop();
    int j = LoginInfoActivity.access$1300(this.this$0).getWidth();
    int k = LoginInfoActivity.access$1400(this.this$0).getRight();
    LoginInfoActivity.access$1200(this.this$0).d((int)AIOUtils.a(j - k - 10, this.this$0.getResources()));
    LoginInfoActivity.access$1200(this.this$0).e((int)AIOUtils.a(i - 10, this.this$0.getResources()));
    LoginInfoActivity.access$1200(this.this$0).a();
    LoginInfoActivity.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.3
 * JD-Core Version:    0.7.0.1
 */