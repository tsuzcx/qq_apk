package com.tencent.mobileqq.ark.api.module;

import android.content.Context;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ArkAppDownloadModule$9
  implements Runnable
{
  ArkAppDownloadModule$9(ArkAppDownloadModule paramArkAppDownloadModule, Context paramContext, WadlParams paramWadlParams) {}
  
  public void run()
  {
    DialogUtil.a(BaseActivity.sTopActivity, 230, null, this.a.getString(2131887047), null, this.a.getString(2131887051), new ArkAppDownloadModule.9.1(this), null).show();
    ReportController.a(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "5", "", this.b.e, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.9
 * JD-Core Version:    0.7.0.1
 */