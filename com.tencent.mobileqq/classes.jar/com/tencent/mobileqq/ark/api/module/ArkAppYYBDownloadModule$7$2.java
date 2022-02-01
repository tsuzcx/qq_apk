package com.tencent.mobileqq.ark.api.module;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.appstore.dl.DownloadManagerV2;

class ArkAppYYBDownloadModule$7$2
  implements DialogInterface.OnClickListener
{
  ArkAppYYBDownloadModule$7$2(ArkAppYYBDownloadModule.7 param7) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      label6:
      DownloadManagerV2.a().a(10, this.a.a);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppYYBDownloadModule.7.2
 * JD-Core Version:    0.7.0.1
 */