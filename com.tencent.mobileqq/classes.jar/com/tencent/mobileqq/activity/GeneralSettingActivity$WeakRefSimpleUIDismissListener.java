package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.CompoundButton;
import mqq.util.WeakReference;

class GeneralSettingActivity$WeakRefSimpleUIDismissListener
  implements DialogInterface.OnDismissListener
{
  WeakReference<GeneralSettingActivity> a;
  WeakReference<CompoundButton> b;
  
  GeneralSettingActivity$WeakRefSimpleUIDismissListener(GeneralSettingActivity paramGeneralSettingActivity, CompoundButton paramCompoundButton)
  {
    this.a = new WeakReference(paramGeneralSettingActivity);
    this.b = new WeakReference(paramCompoundButton);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a;
    CompoundButton localCompoundButton = null;
    if (paramDialogInterface == null) {
      paramDialogInterface = null;
    } else {
      paramDialogInterface = (GeneralSettingActivity)paramDialogInterface.get();
    }
    WeakReference localWeakReference = this.b;
    if (localWeakReference != null) {
      localCompoundButton = (CompoundButton)localWeakReference.get();
    }
    if ((paramDialogInterface != null) && (localCompoundButton != null)) {
      paramDialogInterface.a(localCompoundButton, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.WeakRefSimpleUIDismissListener
 * JD-Core Version:    0.7.0.1
 */