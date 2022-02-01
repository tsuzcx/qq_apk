package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ThemeVersionUpdateBannerProcessor$1
  implements View.OnClickListener
{
  ThemeVersionUpdateBannerProcessor$1(ThemeVersionUpdateBannerProcessor paramThemeVersionUpdateBannerProcessor, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(ThemeVersionUpdateBannerProcessor.a(this.b), QQBrowserActivity.class);
    localIntent.putExtra("individuation_url_type", 40100);
    VasWebviewUtil.b(ThemeVersionUpdateBannerProcessor.b(this.b), IndividuationUrlHelper.a(ThemeVersionUpdateBannerProcessor.c(this.b), "themeDetail", this.a, ""), 32L, localIntent, true, -1);
    BannerManager.a().a(ThemeVersionUpdateBannerProcessor.a, 0, null);
    ReportController.b(ThemeVersionUpdateBannerProcessor.d(this.b).getAppRuntime(), "CliOper", "", "", "0X8005B9F", "0X8005B9F", 0, 0, "", "", "", "");
    ReportController.a(ThemeVersionUpdateBannerProcessor.e(this.b).getAppRuntime(), "dc00898", "", "", "0X8009EE2", "0X8009EE2", 16, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ThemeVersionUpdateBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */