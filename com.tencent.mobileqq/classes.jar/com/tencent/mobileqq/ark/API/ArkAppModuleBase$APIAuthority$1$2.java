package com.tencent.mobileqq.ark.API;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ArkAppModuleBase$APIAuthority$1$2
  implements DialogInterface.OnClickListener
{
  ArkAppModuleBase$APIAuthority$1$2(ArkAppModuleBase.APIAuthority.1 param1, QQCustomDialog paramQQCustomDialog, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleBase$APIAuthority$1.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleBase$APIAuthority$AuthDialogEventHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleBase$APIAuthority$1.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleBase$APIAuthority$AuthDialogEventHandler.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      label39:
      ArkAppModuleBase.APIAuthority.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleBase$APIAuthority$1.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleBase$APIAuthority$1.d, this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleBase$APIAuthority$1.e, 2);
      paramDialogInterface = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131690218), 2131719347, 2131719347, new DialogUtil.DialogOnClickAdapter(), null);
      try
      {
        paramDialogInterface.show();
        return;
      }
      catch (Exception paramDialogInterface) {}
    }
    catch (Exception paramDialogInterface)
    {
      break label39;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleBase.APIAuthority.1.2
 * JD-Core Version:    0.7.0.1
 */