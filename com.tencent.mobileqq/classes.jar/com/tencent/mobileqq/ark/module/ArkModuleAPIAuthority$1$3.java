package com.tencent.mobileqq.ark.module;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ArkModuleAPIAuthority$1$3
  implements DialogInterface.OnClickListener
{
  ArkModuleAPIAuthority$1$3(ArkModuleAPIAuthority.1 param1, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArkModuleArkModuleAPIAuthority$1.jdField_a_of_type_ComTencentMobileqqArkModuleAuthDialogEventHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkModuleArkModuleAPIAuthority$1.jdField_a_of_type_ComTencentMobileqqArkModuleAuthDialogEventHandler.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      label39:
      ArkModuleAPIAuthority.a(this.jdField_a_of_type_ComTencentMobileqqArkModuleArkModuleAPIAuthority$1.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkModuleArkModuleAPIAuthority$1.d, this.jdField_a_of_type_ComTencentMobileqqArkModuleArkModuleAPIAuthority$1.e, 1);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label39;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkModuleAPIAuthority.1.3
 * JD-Core Version:    0.7.0.1
 */