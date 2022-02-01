package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class LoginInfoActivity$8
  implements Runnable
{
  LoginInfoActivity$8(LoginInfoActivity paramLoginInfoActivity, int paramInt) {}
  
  public void run()
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
        if (i != 0)
        {
          if (i == 1) {
            LoginInfoActivity.access$2200(this.this$0).c(2131694668);
          }
        }
        else {
          LoginInfoActivity.access$2200(this.this$0).c(2131718170);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    if ((LoginInfoActivity.access$2200(this.this$0) != null) && (!LoginInfoActivity.access$2200(this.this$0).isShowing())) {
      LoginInfoActivity.access$2200(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.8
 * JD-Core Version:    0.7.0.1
 */