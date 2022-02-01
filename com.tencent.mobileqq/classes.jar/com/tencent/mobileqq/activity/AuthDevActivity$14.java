package com.tencent.mobileqq.activity;

import bhht;

class AuthDevActivity$14
  implements Runnable
{
  AuthDevActivity$14(AuthDevActivity paramAuthDevActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevActivity.a(this.this$0) != null) && (AuthDevActivity.a(this.this$0).isShowing()))
      {
        AuthDevActivity.a(this.this$0).dismiss();
        AuthDevActivity.a(this.this$0).cancel();
      }
      AuthDevActivity.a(this.this$0, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity.14
 * JD-Core Version:    0.7.0.1
 */