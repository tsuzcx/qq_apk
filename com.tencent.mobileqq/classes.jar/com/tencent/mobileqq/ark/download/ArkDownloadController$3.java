package com.tencent.mobileqq.ark.download;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class ArkDownloadController$3
  implements DialogInterface.OnDismissListener
{
  ArkDownloadController$3(ArkDownloadController paramArkDownloadController) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ArkDownloadController.a(this.a, false);
    QLog.d("ark.download.ctrl", 1, "ark.dctrl [showDownloadDialog] onDismiss");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.download.ArkDownloadController.3
 * JD-Core Version:    0.7.0.1
 */