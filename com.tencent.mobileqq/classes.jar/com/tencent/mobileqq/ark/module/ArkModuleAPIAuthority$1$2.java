package com.tencent.mobileqq.ark.module;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ArkModuleAPIAuthority$1$2
  implements DialogInterface.OnClickListener
{
  ArkModuleAPIAuthority$1$2(ArkModuleAPIAuthority.1 param1, QQCustomDialog paramQQCustomDialog, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArkModuleArkModuleAPIAuthority$1.jdField_a_of_type_ComTencentMobileqqArkModuleAuthDialogEventHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkModuleArkModuleAPIAuthority$1.jdField_a_of_type_ComTencentMobileqqArkModuleAuthDialogEventHandler.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      ArkModuleAPIAuthority.a(this.jdField_a_of_type_ComTencentMobileqqArkModuleArkModuleAPIAuthority$1.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkModuleArkModuleAPIAuthority$1.d, this.jdField_a_of_type_ComTencentMobileqqArkModuleArkModuleAPIAuthority$1.e, 2);
      paramDialogInterface = this.jdField_a_of_type_AndroidAppActivity;
      paramDialogInterface = DialogUtil.a(paramDialogInterface, paramDialogInterface.getString(2131690134), 2131719065, 2131719065, new DialogUtil.DialogOnClickAdapter(), null);
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        try
        {
          paramDialogInterface.show();
          return;
        }
        catch (Exception paramDialogInterface) {}
        paramDialogInterface = paramDialogInterface;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkModuleAPIAuthority.1.2
 * JD-Core Version:    0.7.0.1
 */