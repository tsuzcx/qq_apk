package com.tencent.mobileqq.activity;

import bcpq;

class LoginInfoActivity$5
  implements Runnable
{
  LoginInfoActivity$5(LoginInfoActivity paramLoginInfoActivity, int paramInt) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (!this.this$0.isFinishing())
        {
          if ((LoginInfoActivity.a(this.this$0) != null) && (LoginInfoActivity.a(this.this$0).isShowing()))
          {
            LoginInfoActivity.a(this.this$0).dismiss();
            LoginInfoActivity.a(this.this$0).cancel();
            LoginInfoActivity.a(this.this$0, null);
          }
          LoginInfoActivity.a(this.this$0, new bcpq(this.this$0.getActivity(), this.this$0.getTitleBarHeight()));
          int i = this.a;
          switch (i)
          {
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        continue;
        LoginInfoActivity.a(this.this$0).c(2131694930);
        continue;
      }
      if ((LoginInfoActivity.a(this.this$0) != null) && (!LoginInfoActivity.a(this.this$0).isShowing())) {
        LoginInfoActivity.a(this.this$0).show();
      }
      return;
      LoginInfoActivity.a(this.this$0).c(2131718668);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.5
 * JD-Core Version:    0.7.0.1
 */