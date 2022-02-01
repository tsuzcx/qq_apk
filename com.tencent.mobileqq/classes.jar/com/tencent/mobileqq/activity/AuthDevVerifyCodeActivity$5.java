package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class AuthDevVerifyCodeActivity$5
  implements Runnable
{
  AuthDevVerifyCodeActivity$5(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevVerifyCodeActivity.access$300(this.this$0) != null) && (AuthDevVerifyCodeActivity.access$300(this.this$0).isShowing()))
      {
        AuthDevVerifyCodeActivity.access$300(this.this$0).dismiss();
        AuthDevVerifyCodeActivity.access$300(this.this$0).cancel();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    AuthDevVerifyCodeActivity.access$302(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity.5
 * JD-Core Version:    0.7.0.1
 */