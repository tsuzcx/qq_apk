package com.tencent.mobileqq.activity;

import bcqf;

class AuthDevActivity$11
  implements Runnable
{
  AuthDevActivity$11(AuthDevActivity paramAuthDevActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevActivity.a(this.this$0) == null) && (!this.this$0.isFinishing())) {
        AuthDevActivity.a(this.this$0, new bcqf(this.this$0, this.this$0.getTitleBarHeight()));
      }
      if ((AuthDevActivity.a(this.this$0) != null) && (!AuthDevActivity.a(this.this$0).isShowing())) {
        AuthDevActivity.a(this.this$0).show();
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity.11
 * JD-Core Version:    0.7.0.1
 */