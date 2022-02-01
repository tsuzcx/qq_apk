package com.tencent.mobileqq.app.identity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class AccountPhoneUnityManager$6
  implements DialogInterface.OnDismissListener
{
  AccountPhoneUnityManager$6(AccountPhoneUnityManager paramAccountPhoneUnityManager) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AccountPhoneUnityManager.a(this.a, null);
    QLog.d("AccountPhoneUnityManager", 1, "dialog dismiss");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.AccountPhoneUnityManager.6
 * JD-Core Version:    0.7.0.1
 */