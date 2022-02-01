package com.tencent.avgame.floatwindow;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class FloatWindowController$3
  implements DialogInterface.OnDismissListener
{
  FloatWindowController$3(FloatWindowController paramFloatWindowController, Activity paramActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowController.c)
    {
      if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowController.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.floatwindow.FloatWindowController.3
 * JD-Core Version:    0.7.0.1
 */