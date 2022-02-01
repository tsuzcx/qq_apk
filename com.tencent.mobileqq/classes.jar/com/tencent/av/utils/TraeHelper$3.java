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
    if (QLog.isColorLevel()) {
      QLog.d("TraeSessionHelper", 2, "Trae_DRP 0X8008D1E at: " + System.currentTimeMillis());
    }
    ReportController.b(null, "CliOper", "", "", "0X8008D1E", "0X8008D1E", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.3
 * JD-Core Version:    0.7.0.1
 */