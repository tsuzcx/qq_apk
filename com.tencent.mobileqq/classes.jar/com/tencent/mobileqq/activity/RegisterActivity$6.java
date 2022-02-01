package com.tencent.mobileqq.activity;

import biau;

class RegisterActivity$6
  implements Runnable
{
  RegisterActivity$6(RegisterActivity paramRegisterActivity) {}
  
  public void run()
  {
    try
    {
      if (RegisterActivity.a(this.this$0) != null)
      {
        RegisterActivity.a(this.this$0).dismiss();
        RegisterActivity.a(this.this$0).cancel();
        RegisterActivity.a(this.this$0, null);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterActivity.6
 * JD-Core Version:    0.7.0.1
 */