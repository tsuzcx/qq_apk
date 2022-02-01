package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

class TroopInviteStatusFragment$1
  implements Runnable
{
  TroopInviteStatusFragment$1(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  public void run()
  {
    if ((this.this$0.x != null) && (!this.this$0.x.isShowing()) && (this.this$0.l != null))
    {
      if (this.this$0.l.isFinishing()) {
        return;
      }
      this.this$0.x.c(2131915649);
      this.this$0.x.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInviteStatusFragment.1
 * JD-Core Version:    0.7.0.1
 */