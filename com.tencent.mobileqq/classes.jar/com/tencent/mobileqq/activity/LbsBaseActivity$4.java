package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class LbsBaseActivity$4
  implements DialogInterface.OnDismissListener
{
  LbsBaseActivity$4(LbsBaseActivity paramLbsBaseActivity, Runnable paramRunnable) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!LbsBaseActivity.access$100(this.b))
    {
      this.b.onLBSForbidden();
      return;
    }
    LbsBaseActivity.access$200(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LbsBaseActivity.4
 * JD-Core Version:    0.7.0.1
 */