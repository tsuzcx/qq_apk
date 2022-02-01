package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class AuthDevActivity$10
  implements Runnable
{
  AuthDevActivity$10(AuthDevActivity paramAuthDevActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevActivity.access$4400(this.this$0) == null) && (!this.this$0.isFinishing())) {
        AuthDevActivity.access$4402(this.this$0, new QQProgressDialog(this.this$0, this.this$0.getTitleBarHeight()));
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    if ((AuthDevActivity.access$4400(this.this$0) != null) && (!AuthDevActivity.access$4400(this.this$0).isShowing())) {
      AuthDevActivity.access$4400(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity.10
 * JD-Core Version:    0.7.0.1
 */