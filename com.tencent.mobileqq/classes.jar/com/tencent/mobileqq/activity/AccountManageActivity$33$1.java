package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.util.Pair;

class AccountManageActivity$33$1
  implements DialogInterface.OnClickListener
{
  AccountManageActivity$33$1(AccountManageActivity.33 param33, ISubAccountControlService paramISubAccountControlService, Pair paramPair) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqSubaccountApiISubAccountControlService.cancelHintDialog((String)this.jdField_a_of_type_ComTencentUtilPair.first, ((Integer)this.jdField_a_of_type_ComTencentUtilPair.second).intValue(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.33.1
 * JD-Core Version:    0.7.0.1
 */