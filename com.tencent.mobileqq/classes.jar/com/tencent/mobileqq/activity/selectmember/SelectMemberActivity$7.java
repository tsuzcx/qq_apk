package com.tencent.mobileqq.activity.selectmember;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import java.util.ArrayList;

class SelectMemberActivity$7
  implements DialogInterface.OnClickListener
{
  SelectMemberActivity$7(SelectMemberActivity paramSelectMemberActivity, ArrayList paramArrayList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c, this.jdField_a_of_type_JavaUtilArrayList, "");
    SelectMemberActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b.show();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d("Clk_invite");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.7
 * JD-Core Version:    0.7.0.1
 */