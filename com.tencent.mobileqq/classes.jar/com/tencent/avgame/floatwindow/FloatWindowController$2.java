package com.tencent.avgame.floatwindow;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.MobileQQ;

class FloatWindowController$2
  implements DialogInterface.OnClickListener
{
  FloatWindowController$2(FloatWindowController paramFloatWindowController) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = MobileQQ.sMobileQQ;
    paramDialogInterface = MobileQQ.getContext();
    ReportController.b(null, "dc00898", "", "", "0X800B038", "0X800B038", 0, 0, "", "", "", "");
    ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).requestPermission(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.floatwindow.FloatWindowController.2
 * JD-Core Version:    0.7.0.1
 */