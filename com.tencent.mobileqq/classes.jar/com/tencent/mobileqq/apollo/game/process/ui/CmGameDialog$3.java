package com.tencent.mobileqq.apollo.game.process.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class CmGameDialog$3
  implements DialogInterface.OnClickListener
{
  CmGameDialog$3(CmGameDialog paramCmGameDialog, NativeUIManager paramNativeUIManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessUiNativeUIManager;
    if (paramDialogInterface != null) {
      paramDialogInterface.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessUiCmGameDialog.a(), "sc.xy_alert_show_success.local", "{\"confirm\":1}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.ui.CmGameDialog.3
 * JD-Core Version:    0.7.0.1
 */