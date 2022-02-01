package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class AuthDevRenameActivity$4
  implements Runnable
{
  AuthDevRenameActivity$4(AuthDevRenameActivity paramAuthDevRenameActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevRenameActivity.access$100(this.this$0) == null) && (!this.this$0.isFinishing())) {
        AuthDevRenameActivity.access$102(this.this$0, new QQProgressDialog(this.this$0, this.this$0.getTitleBarHeight()));
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    if ((AuthDevRenameActivity.access$100(this.this$0) != null) && (!AuthDevRenameActivity.access$100(this.this$0).isShowing()))
    {
      AuthDevRenameActivity.access$100(this.this$0).a(this.this$0.getString(2131889009));
      AuthDevRenameActivity.access$100(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevRenameActivity.4
 * JD-Core Version:    0.7.0.1
 */