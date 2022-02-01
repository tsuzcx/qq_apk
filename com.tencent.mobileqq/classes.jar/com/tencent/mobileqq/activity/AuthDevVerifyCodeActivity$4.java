package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class AuthDevVerifyCodeActivity$4
  implements Runnable
{
  AuthDevVerifyCodeActivity$4(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevVerifyCodeActivity.access$300(this.this$0) == null) && (!this.this$0.isFinishing()))
      {
        AuthDevVerifyCodeActivity.access$302(this.this$0, new QQProgressDialog(this.this$0, this.this$0.getTitleBarHeight()));
        AuthDevVerifyCodeActivity.access$300(this.this$0).c(2131694668);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    if ((AuthDevVerifyCodeActivity.access$300(this.this$0) != null) && (!AuthDevVerifyCodeActivity.access$300(this.this$0).isShowing())) {
      AuthDevVerifyCodeActivity.access$300(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity.4
 * JD-Core Version:    0.7.0.1
 */