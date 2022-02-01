package com.tencent.mobileqq.ark.api.module;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ArkAppDownloadModule$5
  implements Runnable
{
  ArkAppDownloadModule$5(ArkAppDownloadModule paramArkAppDownloadModule, Context paramContext, String paramString1, int paramInt, String paramString2, SharedPreferences paramSharedPreferences, String paramString3, String paramString4) {}
  
  public void run()
  {
    Object localObject = this.a;
    localObject = DialogUtil.a((Context)localObject, 230, null, this.b, ((Context)localObject).getString(2131887648), this.a.getString(2131887044), new ArkAppDownloadModule.5.1(this), new ArkAppDownloadModule.5.2(this));
    ((QQCustomDialog)localObject).setCheckBox(this.g, null);
    ((QQCustomDialog)localObject).show();
    ReportController.a(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "6", "", this.d, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.5
 * JD-Core Version:    0.7.0.1
 */