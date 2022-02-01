package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class LoginInfoActivity$8
  implements Runnable
{
  LoginInfoActivity$8(LoginInfoActivity paramLoginInfoActivity, int paramInt) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (!this.this$0.isFinishing())
        {
          if ((LoginInfoActivity.access$2200(this.this$0) != null) && (LoginInfoActivity.access$2200(this.this$0).isShowing()))
          {
            LoginInfoActivity.access$2200(this.this$0).dismiss();
            LoginInfoActivity.access$2200(this.this$0).cancel();
            LoginInfoActivity.access$2202(this.this$0, null);
          }
          LoginInfoActivity.access$2202(this.this$0, new QQProgressDialog(this.this$0.getActivity(), this.this$0.getTitleBarHeight()));
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
        LoginInfoActivity.access$2200(this.this$0).c(2131694694);
        continue;
      }
      if ((LoginInfoActivity.access$2200(this.this$0) != null) && (!LoginInfoActivity.access$2200(this.this$0).isShowing())) {
        LoginInfoActivity.access$2200(this.this$0).show();
      }
      return;
      LoginInfoActivity.access$2200(this.this$0).c(2131718505);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.8
 * JD-Core Version:    0.7.0.1
 */