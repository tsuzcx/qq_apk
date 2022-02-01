package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ThemeOverdueBannerProcessor$1
  implements View.OnClickListener
{
  ThemeOverdueBannerProcessor$1(ThemeOverdueBannerProcessor paramThemeOverdueBannerProcessor, int paramInt1, int paramInt2, String paramString, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    ThemeHandler.a(this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, this.c, (BaseActivity)ThemeOverdueBannerProcessor.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorThemeOverdueBannerProcessor));
    ReportController.b(null, "CliOper", "", "", "theme", "0X8007233", 0, 0, String.valueOf(this.c), "", "", "");
    BannerManager.a().a(ThemeOverdueBannerProcessor.jdField_a_of_type_Int, 0, null);
    ReportController.a(ThemeOverdueBannerProcessor.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorThemeOverdueBannerProcessor).getAppRuntime(), "dc00898", "", "", "0X8009EE2", "0X8009EE2", 15, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ThemeOverdueBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */