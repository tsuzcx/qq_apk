package com.tencent.mobileqq.ark.debug;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.widget.ActionSheet;

class ArkIDESettingFragment$4$1
  implements DialogInterface.OnDismissListener
{
  ArkIDESettingFragment$4$1(ArkIDESettingFragment.4 param4, ActionSheet paramActionSheet) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    ArkAppCenter.a("ArkApp.DebugOnlineActivity", String.format("ClearData actionsheet is closed", new Object[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.ArkIDESettingFragment.4.1
 * JD-Core Version:    0.7.0.1
 */