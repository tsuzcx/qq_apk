package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

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
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    AuthDevRenameActivity.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevRenameActivity.5
 * JD-Core Version:    0.7.0.1
 */