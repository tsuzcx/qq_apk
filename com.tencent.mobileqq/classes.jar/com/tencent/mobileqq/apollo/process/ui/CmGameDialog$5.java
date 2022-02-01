package com.tencent.mobileqq.apollo.process.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class CmGameDialog$5
  implements DialogInterface.OnKeyListener
{
  CmGameDialog$5(CmGameDialog paramCmGameDialog, NativeUIManager paramNativeUIManager) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiNativeUIManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiNativeUIManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiCmGameDialog.a(), "sc.xy_alert_show_success.local", "{\"cancel\":1}");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.CmGameDialog.5
 * JD-Core Version:    0.7.0.1
 */