package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.widget.LinearLayout;

class AccountManageActivity$19$1
  implements Runnable
{
  AccountManageActivity$19$1(AccountManageActivity.19 param19) {}
  
  public void run()
  {
    try
    {
      this.a.this$0.a.removeViewAt(this.a.c);
      label20:
      boolean bool = this.a.this$0.k;
      int i = 0;
      if (!bool) {
        this.a.this$0.a(false);
      }
      AccountManageActivity.a(this.a.this$0, null);
      int j = this.a.this$0.a.getChildCount();
      while (i < j)
      {
        View localView = this.a.this$0.a.getChildAt(i);
        if (localView.getTag() != null) {
          localView.setTag(Integer.valueOf(i));
        }
        i += 1;
      }
      this.a.this$0.g.dismiss();
      return;
    }
    catch (Exception localException)
    {
      break label20;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.19.1
 * JD-Core Version:    0.7.0.1
 */