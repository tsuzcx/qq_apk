package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qphone.base.util.QLog;

class AccountIdentityManager$6
  implements DialogInterface.OnCancelListener
{
  AccountIdentityManager$6(AccountIdentityManager paramAccountIdentityManager, Activity paramActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    QLog.d("AccountIdentityManager", 1, "dialog cancel");
    AccountIdentityManager.a(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.AccountIdentityManager.6
 * JD-Core Version:    0.7.0.1
 */