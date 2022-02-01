package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class ThemeVersionUpdateBannerProcessor
  extends BaseBannerProcessor
{
  public static final int a;
  
  static
  {
    jdField_a_of_type_Int = BannerTypeCollections.A;
  }
  
  public ThemeVersionUpdateBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public int a()
  {
    return 4;
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    paramBanner.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131691313));
    paramBanner.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130838218));
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity == null) {
      return;
    }
    paramBanner.a.setVisibility(0);
    ((TipsBar)paramBanner.a).setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131691313));
    AppRuntime localAppRuntime;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null) {
      localAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
    } else {
      localAppRuntime = null;
    }
    if (localAppRuntime == null) {
      return;
    }
    if (paramMessage != null)
    {
      if (paramMessage.obj == null) {
        return;
      }
      paramMessage = (String)paramMessage.obj;
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 16, 0, "", "", "", "");
      paramBanner.a.setOnClickListener(new ThemeVersionUpdateBannerProcessor.1(this, paramMessage));
    }
  }
  
  public int b()
  {
    return jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ThemeVersionUpdateBannerProcessor
 * JD-Core Version:    0.7.0.1
 */