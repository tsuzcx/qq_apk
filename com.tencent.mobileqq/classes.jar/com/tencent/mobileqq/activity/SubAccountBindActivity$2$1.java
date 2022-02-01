package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;

class SubAccountBindActivity$2$1
  implements DialogInterface.OnClickListener
{
  SubAccountBindActivity$2$1(SubAccountBindActivity.2 param2, SubAccountBackProtocData paramSubAccountBackProtocData) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramInt == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSubaccountLogicSubAccountBackProtocData.c)))
    {
      paramDialogInterface = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountBindActivity$2.a, SubLoginActivity.class);
      paramDialogInterface.putExtra("subuin", this.jdField_a_of_type_ComTencentMobileqqSubaccountLogicSubAccountBackProtocData.c);
      paramDialogInterface.putExtra("fromWhere", this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountBindActivity$2.a.fromWhere);
      this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountBindActivity$2.a.startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity.2.1
 * JD-Core Version:    0.7.0.1
 */