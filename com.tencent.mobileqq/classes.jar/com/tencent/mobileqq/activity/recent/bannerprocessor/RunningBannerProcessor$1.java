package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_dc00307;
import cooperation.qzone.report.lp.LpReportManager;
import java.net.URLEncoder;
import mqq.os.MqqHandler;

class RunningBannerProcessor$1
  implements View.OnClickListener
{
  RunningBannerProcessor$1(RunningBannerProcessor paramRunningBannerProcessor, String paramString, Long paramLong, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (!RunningBannerProcessor.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorRunningBannerProcessor)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      RunningBannerProcessor.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorRunningBannerProcessor, false);
      new Handler().postDelayed(new RunningBannerProcessor.1.1(this), 1000L);
      Object localObject1 = ((QQAppInterface)RunningBannerProcessor.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorRunningBannerProcessor).getAppRuntime()).getCurrentAccountUin();
      Object localObject2 = new StringBuilder(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("?");
      ((StringBuilder)localObject2).append("uin=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("&plat=1");
      ((StringBuilder)localObject2).append("&app=1");
      ((StringBuilder)localObject2).append("&version=8.5.5.5105");
      ((StringBuilder)localObject2).append("&device=" + URLEncoder.encode(Build.DEVICE));
      ((StringBuilder)localObject2).append("&system=" + Build.VERSION.RELEASE);
      ((StringBuilder)localObject2).append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
      localObject2 = ((StringBuilder)localObject2).toString();
      Intent localIntent = new Intent();
      localIntent.putExtra("portraitOnly", true);
      localIntent.putExtra("url", (String)localObject2);
      localIntent.putExtra("uin", (String)localObject1);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      VasWebviewUtil.openQQBrowserActivity(RunningBannerProcessor.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorRunningBannerProcessor), (String)localObject2, 32768L, localIntent, false, -1);
      if (this.jdField_a_of_type_JavaLangLong.longValue() == 3L)
      {
        RunningBannerProcessor.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorRunningBannerProcessor).sendEmptyMessage(3000);
        localObject1 = new LpReportInfo_dc00307(LpReportInfo_dc00307.ACTION_TYPE_RED_PACK, LpReportInfo_dc00307.SUB_ACTION_TYPE_RED_PACK_CLICK, this.jdField_a_of_type_Int);
        LpReportManager.getInstance().reportToDC00307((LpReportInfo_dc00307)localObject1, false, true);
      }
      ReportController.a(RunningBannerProcessor.c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorRunningBannerProcessor).getAppRuntime(), "dc00898", "", "", "0X8009EE3", "0X8009EE3", 9, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.RunningBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */