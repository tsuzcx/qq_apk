package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

class GeneralSettingActivity$18
  implements DialogInterface.OnClickListener
{
  GeneralSettingActivity$18(GeneralSettingActivity paramGeneralSettingActivity, Runnable paramRunnable) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramDialogInterface instanceof QQCustomDialog)) {
      ((QQCustomDialog)paramDialogInterface).setOnDismissListener(null);
    }
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.18
 * JD-Core Version:    0.7.0.1
 */