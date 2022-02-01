package com.tencent.mobileqq.ark.download;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ArkDownloadController$2
  implements DialogInterface.OnClickListener
{
  ArkDownloadController$2(ArkDownloadController paramArkDownloadController, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = ArkDownloadController.a(this.b);
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < ArkDownloadController.b(this.b).size())
        {
          ArkDownloadItem localArkDownloadItem = (ArkDownloadItem)ArkDownloadController.b(this.b).get(i);
          if (localArkDownloadItem != null) {
            localArkDownloadItem.d.onClick(ArkDownloadController.c(this.b), paramInt);
          }
        }
        else
        {
          try
          {
            ArkDownloadController.a(this.b, false);
            if ((ArkDownloadController.c(this.b) != null) && (ArkDownloadController.c(this.b).isShowing())) {
              ArkDownloadController.c(this.b).dismiss();
            }
            ArkDownloadController.a(this.b, this.a);
          }
          catch (Exception paramDialogInterface)
          {
            QLog.e("ark.download.ctrl", 1, "ark.dctrl [onClickListener] clicked dismiss exception:", paramDialogInterface);
          }
          QLog.d("ark.download.ctrl", 1, new Object[] { "ark.dctrl [onClickListener] which=", Integer.valueOf(paramInt), ",cost=", Long.valueOf(Math.abs(System.currentTimeMillis() - ArkDownloadController.d(this.b))) });
          if (paramInt == 1)
          {
            ReportController.a(null, "dc00898", "", "", "0X800AD1D", "0X800AD1D", 3, 0, String.valueOf(ArkDownloadController.e(this.b)), "", this.a, "");
            return;
          }
          if (paramInt == 0) {
            ReportController.a(null, "dc00898", "", "", "0X800AD1E", "0X800AD1E", 3, 0, String.valueOf(ArkDownloadController.e(this.b)), "", this.a, "");
          }
          return;
        }
      }
      finally
      {
        continue;
        throw localObject;
        continue;
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.download.ArkDownloadController.2
 * JD-Core Version:    0.7.0.1
 */