package com.tencent.mobileqq.ark.api.module;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class ArkAppDownloadModule$5$2
  implements DialogInterface.OnClickListener
{
  ArkAppDownloadModule$5$2(ArkAppDownloadModule.5 param5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    ReportController.a(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "8", "", this.a.d, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.5.2
 * JD-Core Version:    0.7.0.1
 */