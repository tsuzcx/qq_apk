package com.tencent.mobileqq.apollo.process.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class CmGameDialog$4
  implements DialogInterface.OnClickListener
{
  CmGameDialog$4(CmGameDialog paramCmGameDialog, NativeUIManager paramNativeUIManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiNativeUIManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiNativeUIManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameDialog.a(), "sc.xy_alert_show_success.local", "{\"cancel\":1}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.CmGameDialog.4
 * JD-Core Version:    0.7.0.1
 */