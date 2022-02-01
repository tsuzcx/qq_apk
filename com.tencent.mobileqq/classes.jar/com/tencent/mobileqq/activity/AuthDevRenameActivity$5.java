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
      if ((AuthDevRenameActivity.access$100(this.this$0) != null) && (AuthDevRenameActivity.access$100(this.this$0).isShowing()))
      {
        AuthDevRenameActivity.access$100(this.this$0).dismiss();
        AuthDevRenameActivity.access$100(this.this$0).cancel();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    AuthDevRenameActivity.access$102(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevRenameActivity.5
 * JD-Core Version:    0.7.0.1
 */