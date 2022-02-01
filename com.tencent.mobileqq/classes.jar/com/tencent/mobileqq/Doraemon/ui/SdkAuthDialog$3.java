package com.tencent.mobileqq.Doraemon.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class SdkAuthDialog$3
  implements DialogInterface.OnCancelListener
{
  SdkAuthDialog$3(SdkAuthDialog paramSdkAuthDialog, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    DialogInterface.OnCancelListener localOnCancelListener = this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener;
    if (localOnCancelListener == null)
    {
      QLog.e("SdkAuthDialog", 1, "cancelListener is null");
      return;
    }
    localOnCancelListener.onCancel(paramDialogInterface);
    ReportController.b(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "1", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.ui.SdkAuthDialog.3
 * JD-Core Version:    0.7.0.1
 */