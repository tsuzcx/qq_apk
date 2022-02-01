package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class AccountIdentityManager$5
  implements DialogInterface.OnDismissListener
{
  AccountIdentityManager$5(AccountIdentityManager paramAccountIdentityManager, Activity paramActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QLog.d("AccountIdentityManager", 1, "dialog dismiss");
    AccountIdentityManager.a(this.jdField_a_of_type_ComTencentMobileqqAppIdentityAccountIdentityManager, this.jdField_a_of_type_AndroidAppActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.AccountIdentityManager.5
 * JD-Core Version:    0.7.0.1
 */