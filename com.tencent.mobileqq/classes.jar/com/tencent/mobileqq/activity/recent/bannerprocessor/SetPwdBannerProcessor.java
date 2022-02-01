package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class SetPwdBannerProcessor
  extends BaseBannerProcessor
{
  public static final int a;
  private boolean a;
  
  static
  {
    jdField_a_of_type_Int = BannerTypeCollections.t;
  }
  
  public SetPwdBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void b()
  {
    ThreadManager.getSubThreadHandler().post(new SetPwdBannerProcessor.2(this));
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    paramBanner.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130839471));
    paramBanner.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131718808));
    paramBanner.setOnClickListener(new SetPwdBannerProcessor.1(this));
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 18, 0, "", "", "", "");
    return paramBanner;
  }
  
  public void a()
  {
    b();
  }
  
  public void a(Message paramMessage, long paramLong, boolean paramBoolean)
  {
    if (paramMessage.what == 3000) {
      b();
    }
  }
  
  public int b()
  {
    return jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.SetPwdBannerProcessor
 * JD-Core Version:    0.7.0.1
 */