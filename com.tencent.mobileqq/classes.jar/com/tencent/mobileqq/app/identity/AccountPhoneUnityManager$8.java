package com.tencent.mobileqq.app.identity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qphone.base.util.QLog;

class AccountPhoneUnityManager$8
  implements DialogInterface.OnCancelListener
{
  AccountPhoneUnityManager$8(AccountPhoneUnityManager paramAccountPhoneUnityManager) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    AccountPhoneUnityManager.a(this.a, null);
    QLog.d("AccountPhoneUnityManager", 1, "dialog cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.AccountPhoneUnityManager.8
 * JD-Core Version:    0.7.0.1
 */