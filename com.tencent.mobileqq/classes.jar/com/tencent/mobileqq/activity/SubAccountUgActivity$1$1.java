package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.util.Pair;

class SubAccountUgActivity$1$1
  implements DialogInterface.OnClickListener
{
  SubAccountUgActivity$1$1(SubAccountUgActivity.1 param1, SubAccountControll paramSubAccountControll, Pair paramPair) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountControll.a((String)this.jdField_a_of_type_ComTencentUtilPair.first, ((Integer)this.jdField_a_of_type_ComTencentUtilPair.second).intValue(), true);
    if (!SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity$1.a.app))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity$1.a.setTitle("");
      SubAccountAssistantForward.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity$1.a.app, this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity$1.a, null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity$1.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountUgActivity.1.1
 * JD-Core Version:    0.7.0.1
 */