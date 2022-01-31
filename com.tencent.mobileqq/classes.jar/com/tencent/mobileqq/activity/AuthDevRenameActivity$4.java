package com.tencent.mobileqq.activity;

import bbms;

class AuthDevRenameActivity$4
  implements Runnable
{
  AuthDevRenameActivity$4(AuthDevRenameActivity paramAuthDevRenameActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevRenameActivity.a(this.this$0) == null) && (!this.this$0.isFinishing())) {
        AuthDevRenameActivity.a(this.this$0, new bbms(this.this$0, this.this$0.getTitleBarHeight()));
      }
      if ((AuthDevRenameActivity.a(this.this$0) != null) && (!AuthDevRenameActivity.a(this.this$0).isShowing()))
      {
        AuthDevRenameActivity.a(this.this$0).a(this.this$0.getString(2131626580));
        AuthDevRenameActivity.a(this.this$0).show();
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
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevRenameActivity.4
 * JD-Core Version:    0.7.0.1
 */