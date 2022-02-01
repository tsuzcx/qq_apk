package com.tencent.mobileqq.ark.API;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.mobileqq.statistics.ReportController;

class ArkAppDownloadModule$10$2
  implements DialogInterface.OnClickListener
{
  ArkAppDownloadModule$10$2(ArkAppDownloadModule.10 param10) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    ReportController.a(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "8", "", this.a.a.a, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDownloadModule.10.2
 * JD-Core Version:    0.7.0.1
 */