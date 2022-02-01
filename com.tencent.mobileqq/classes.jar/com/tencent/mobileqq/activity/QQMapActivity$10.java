package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class QQMapActivity$10
  implements DialogInterface.OnDismissListener
{
  QQMapActivity$10(QQMapActivity paramQQMapActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.a.l) && (!this.a.m) && (!this.a.k)) {
      this.a.finish();
    }
    this.a.m = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity.10
 * JD-Core Version:    0.7.0.1
 */