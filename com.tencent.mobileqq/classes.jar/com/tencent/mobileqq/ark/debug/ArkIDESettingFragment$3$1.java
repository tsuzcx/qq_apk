package com.tencent.mobileqq.ark.debug;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.widget.ActionSheet;

class ArkIDESettingFragment$3$1
  implements DialogInterface.OnDismissListener
{
  ArkIDESettingFragment$3$1(ArkIDESettingFragment.3 param3, ActionSheet paramActionSheet) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.dismiss();
    ArkAppCenter.a("ArkApp.DebugOnlineActivity", String.format("ClearApp actionsheet is closed", new Object[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.ArkIDESettingFragment.3.1
 * JD-Core Version:    0.7.0.1
 */