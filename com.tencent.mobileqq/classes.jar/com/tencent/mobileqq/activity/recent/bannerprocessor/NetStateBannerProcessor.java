package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;

@KeepClassConstructor
public class NetStateBannerProcessor
  extends BaseBannerProcessor
{
  public static final int a;
  
  static
  {
    jdField_a_of_type_Int = BannerTypeCollections.jdField_a_of_type_Int;
  }
  
  public NetStateBannerProcessor(QBaseActivity paramQBaseActivity)
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
    paramBanner.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131694427));
    paramBanner.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130838218));
    paramBanner.setOnClickListener(new NetStateBannerProcessor.1(this));
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner.a.setVisibility(0);
    ((TipsBar)paramBanner.a).setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131694427));
    if (BannerManager.a().a(PCOnlineBannerProcessor.jdField_a_of_type_Int))
    {
      BannerManager.a().a(PCOnlineBannerProcessor.jdField_a_of_type_Int, 0);
      BannerManager.a().b(LoginDevicesBannerProcessor.jdField_a_of_type_Int, 2003);
      BannerManager.a().b(PCOnlineBannerProcessor.jdField_a_of_type_Int, 2004);
      BannerManager.a().b(PCOnlineBannerProcessor.jdField_a_of_type_Int, 2001);
      BannerManager.a().b(PCOnlineBannerProcessor.jdField_a_of_type_Int, 2000);
    }
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 1, 0, "", "", "", "");
  }
  
  public int b()
  {
    return jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.NetStateBannerProcessor
 * JD-Core Version:    0.7.0.1
 */