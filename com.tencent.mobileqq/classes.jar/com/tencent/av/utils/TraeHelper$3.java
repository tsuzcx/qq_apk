package com.tencent.av.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class TraeHelper$3
  implements DialogInterface.OnShowListener
{
  TraeHelper$3(TraeHelper paramTraeHelper) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel())
    {
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("Trae_DRP 0X8008D1E at: ");
      paramDialogInterface.append(System.currentTimeMillis());
      QLog.d("TraeSessionHelper", 2, paramDialogInterface.toString());
    }
    ReportController.b(null, "CliOper", "", "", "0X8008D1E", "0X8008D1E", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.3
 * JD-Core Version:    0.7.0.1
 */