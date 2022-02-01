package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class AuthDevActivity$11
  implements Runnable
{
  AuthDevActivity$11(AuthDevActivity paramAuthDevActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevActivity.access$4400(this.this$0) != null) && (AuthDevActivity.access$4400(this.this$0).isShowing()))
      {
        AuthDevActivity.access$4400(this.this$0).dismiss();
        AuthDevActivity.access$4400(this.this$0).cancel();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    AuthDevActivity.access$4402(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity.11
 * JD-Core Version:    0.7.0.1
 */