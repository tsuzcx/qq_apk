package com.tencent.mobileqq.ark.api.module;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class ArkAppDownloadModule$5$1
  implements DialogInterface.OnClickListener
{
  ArkAppDownloadModule$5$1(ArkAppDownloadModule.5 param5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ArkAppDownloadModule.a(this.a.this$0, true);
    WadlProxyServiceUtil.a().b(this.a.c, this.a.d);
    ReportController.a(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "7", "", this.a.d, "");
    if ((paramDialogInterface instanceof QQCustomDialog))
    {
      boolean bool = ((QQCustomDialog)paramDialogInterface).getCheckBoxState();
      if (this.a.e != null) {
        try
        {
          this.a.e.edit().putBoolean(this.a.f, bool ^ true).apply();
          return;
        }
        catch (Exception paramDialogInterface)
        {
          QLog.e("ark.download.module", 1, "ark.dctrl.continue download sp error : ", paramDialogInterface);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.5.1
 * JD-Core Version:    0.7.0.1
 */