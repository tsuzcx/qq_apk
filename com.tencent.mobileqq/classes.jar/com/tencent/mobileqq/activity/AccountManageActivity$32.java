package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import com.tencent.mobileqq.relationx.util.UnLeakOnDismissListenerWrapper;

class AccountManageActivity$32
  extends UnLeakOnDismissListenerWrapper
{
  AccountManageActivity$32(AccountManageActivity paramAccountManageActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((paramDialogInterface != null) && ((paramDialogInterface instanceof Dialog))) {
      ((Dialog)paramDialogInterface).setOnDismissListener(null);
    }
    if (paramDialogInterface == this.a.t) {
      this.a.t = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.32
 * JD-Core Version:    0.7.0.1
 */