package com.tencent.mobileqq.Doraemon.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class SdkAuthDialog$4
  implements DialogInterface.OnKeyListener
{
  SdkAuthDialog$4(SdkAuthDialog paramSdkAuthDialog, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1))
    {
      paramKeyEvent = this.a;
      if (paramKeyEvent == null)
      {
        QLog.e("SdkAuthDialog", 1, "keyListener is null");
        return true;
      }
      paramKeyEvent.onCancel(paramDialogInterface);
      this.b.a();
      ReportController.b(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "1", "", "", "");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.ui.SdkAuthDialog.4
 * JD-Core Version:    0.7.0.1
 */