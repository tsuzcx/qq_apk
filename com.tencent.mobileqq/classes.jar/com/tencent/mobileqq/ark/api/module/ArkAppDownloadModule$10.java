package com.tencent.mobileqq.ark.api.module;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class ArkAppDownloadModule$10
  implements Runnable
{
  ArkAppDownloadModule$10(ArkAppDownloadModule paramArkAppDownloadModule, Context paramContext, String paramString1, WadlParams paramWadlParams, SharedPreferences paramSharedPreferences, String paramString2, String paramString3) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject == null)
    {
      QLog.e("ark.download.module", 1, "start download context is null");
      return;
    }
    localObject = DialogUtil.a((Context)localObject, 230, null, this.b, ((Context)localObject).getString(2131887648), this.a.getString(2131887044), new ArkAppDownloadModule.10.1(this), new ArkAppDownloadModule.10.2(this));
    ((QQCustomDialog)localObject).setCheckBox(this.f, null);
    ((QQCustomDialog)localObject).show();
    ReportController.a(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "6", "", this.c.e, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.10
 * JD-Core Version:    0.7.0.1
 */