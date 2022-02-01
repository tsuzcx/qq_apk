package com.tencent.avgame.floatwindow;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenPermission;
import com.tencent.mobileqq.statistics.ReportController;

class FloatWindowController$2
  implements DialogInterface.OnClickListener
{
  FloatWindowController$2(FloatWindowController paramFloatWindowController, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = BaseApplicationImpl.getContext();
    ReportController.b(null, "dc00898", "", "", "0X800B038", "0X800B038", 0, 0, "", "", "", "");
    if (FloatingScreenPermission.requestPermission(paramDialogInterface))
    {
      this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowController.c = true;
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.floatwindow.FloatWindowController.2
 * JD-Core Version:    0.7.0.1
 */