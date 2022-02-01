package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.chat.NotificationBannerManager;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.widget.AdvancedTipsBar;

@KeepClassConstructor
public class NotificationGuideBannerProcessor
  extends BaseBannerProcessor
{
  public static final int a;
  
  static
  {
    jdField_a_of_type_Int = BannerTypeCollections.u;
  }
  
  public NotificationGuideBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = new AdvancedTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    NotificationBannerManager.a((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).a(BannerManager.a(), (BaseActivity)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramBanner);
    return paramBanner;
  }
  
  public void a()
  {
    BannerManager.a().a(jdField_a_of_type_Int, 0);
  }
  
  public void a(Message paramMessage, long paramLong, boolean paramBoolean)
  {
    if (paramMessage.what == 3000) {
      NotificationBannerManager.a((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).a(BannerManager.a(), paramMessage);
    }
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    NotificationBannerManager.a((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).a(BannerManager.a(), paramBanner.a);
  }
  
  public int b()
  {
    return jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.NotificationGuideBannerProcessor
 * JD-Core Version:    0.7.0.1
 */