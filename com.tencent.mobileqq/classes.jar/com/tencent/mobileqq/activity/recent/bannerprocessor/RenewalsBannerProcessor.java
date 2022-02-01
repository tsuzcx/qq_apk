package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.redtouch.VipBannerInfo;
import cooperation.vip.ad.TianshuRenewalsBarManager;

@KeepClassConstructor
public class RenewalsBannerProcessor
  extends BaseBannerProcessor
{
  public VipBannerInfo a;
  
  public RenewalsBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public static void a(VipBannerInfo paramVipBannerInfo)
  {
    if (BannerManager.a().a(26) != 0) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.obj = paramVipBannerInfo;
    BannerManager.a().a(26, 2, localMessage);
  }
  
  public static void b()
  {
    if (BannerManager.a().a(26) != 0) {
      BannerManager.a().a(26, 0, null);
    }
  }
  
  public int a()
  {
    return super.a();
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131562205, null);
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a()
  {
    BannerManager.a().a(26, 0);
  }
  
  public void a(Message paramMessage, long paramLong, boolean paramBoolean)
  {
    if (paramMessage.what == 2000) {
      a((VipBannerInfo)paramMessage.obj);
    }
    while (paramMessage.what != 2001) {
      return;
    }
    b();
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (paramMessage != null)
    {
      if ((paramMessage.obj instanceof VipBannerInfo))
      {
        paramMessage = (VipBannerInfo)paramMessage.obj;
        this.jdField_a_of_type_ComTencentMobileqqRedtouchVipBannerInfo = paramMessage;
        TianshuRenewalsBarManager.a((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramBanner.a, paramMessage, BannerManager.a().a);
      }
      return;
    }
    if (paramBanner.a.getVisibility() == 8)
    {
      BannerManager.a().a(26, 0, null);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchVipBannerInfo = null;
      return;
    }
    TianshuRenewalsBarManager.b((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramBanner.a, this.jdField_a_of_type_ComTencentMobileqqRedtouchVipBannerInfo, BannerManager.a().a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.RenewalsBannerProcessor
 * JD-Core Version:    0.7.0.1
 */