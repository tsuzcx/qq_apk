package com.tencent.mobileqq.Doraemon.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.statistics.ReportController;

class SdkAuthDialog$3
  implements DialogInterface.OnCancelListener
{
  SdkAuthDialog$3(SdkAuthDialog paramSdkAuthDialog, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener == null)
    {
      QLog.e("SdkAuthDialog", 1, "cancelListener is null");
      return;
    }
    this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener.onCancel(paramDialogInterface);
    ReportController.b(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "1", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.ui.SdkAuthDialog.3
 * JD-Core Version:    0.7.0.1
 */