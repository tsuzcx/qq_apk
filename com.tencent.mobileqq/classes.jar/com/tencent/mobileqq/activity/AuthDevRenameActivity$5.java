package com.tencent.mobileqq.activity;

import bety;

class AuthDevRenameActivity$5
  implements Runnable
{
  AuthDevRenameActivity$5(AuthDevRenameActivity paramAuthDevRenameActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevRenameActivity.a(this.this$0) != null) && (AuthDevRenameActivity.a(this.this$0).isShowing()))
      {
        AuthDevRenameActivity.a(this.this$0).dismiss();
        AuthDevRenameActivity.a(this.this$0).cancel();
      }
      AuthDevRenameActivity.a(this.this$0, null);
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
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevRenameActivity.5
 * JD-Core Version:    0.7.0.1
 */