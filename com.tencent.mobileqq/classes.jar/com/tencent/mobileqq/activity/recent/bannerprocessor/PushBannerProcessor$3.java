package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.config.ConfigManager;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.struct.PushBanner;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PushBannerProcessor$3
  implements View.OnClickListener
{
  PushBannerProcessor$3(PushBannerProcessor paramPushBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    PushBanner localPushBanner = (PushBanner)paramView.getTag();
    if (localPushBanner != null)
    {
      localPushBanner.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.f();
      int i = 0;
      try
      {
        if (!TextUtils.isEmpty(localPushBanner.jdField_a_of_type_JavaLangString)) {
          i = Integer.parseInt(localPushBanner.jdField_a_of_type_JavaLangString);
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        i = 0;
      }
      ReportController.b(PushBannerProcessor.g(this.a).getAppRuntime(), "dc00898", "", "", "0X80087C1", "0X80087C1", i, 0, "", "", "", "");
      ConfigManager localConfigManager = new ConfigManager(PushBannerProcessor.h(this.a).getApplicationContext(), ConfigServlet.jdField_a_of_type_JavaLangString);
      localConfigManager.b();
      localConfigManager.c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.PushBannerProcessor.3
 * JD-Core Version:    0.7.0.1
 */