package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class RegisterActivity$6
  implements Runnable
{
  RegisterActivity$6(RegisterActivity paramRegisterActivity) {}
  
  public void run()
  {
    try
    {
      if (RegisterActivity.c(this.this$0) != null)
      {
        RegisterActivity.c(this.this$0).dismiss();
        RegisterActivity.c(this.this$0).cancel();
        RegisterActivity.a(this.this$0, null);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterActivity.6
 * JD-Core Version:    0.7.0.1
 */