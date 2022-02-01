package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.redtouch.VipBannerInfo;
import cooperation.vip.ad.TianshuRenewalsBarManager;

@KeepClassConstructor
public class RenewalsBannerProcessor
  extends BaseBannerProcessor
{
  public static final int a = BannerTypeCollections.A;
  public VipBannerInfo b;
  
  public RenewalsBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public static void a(VipBannerInfo paramVipBannerInfo)
  {
    if (BannerManager.a().b(a) != 0) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.obj = paramVipBannerInfo;
    BannerManager.a().a(a, 2, localMessage);
  }
  
  public static void d()
  {
    if (BannerManager.a().b(a) != 0) {
      BannerManager.a().a(a, 0, null);
    }
  }
  
  public int a()
  {
    return super.a();
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = View.inflate(this.f, 2131628468, null);
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(Message paramMessage, long paramLong, boolean paramBoolean)
  {
    if (paramMessage.what == 2000)
    {
      a((VipBannerInfo)paramMessage.obj);
      return;
    }
    if (paramMessage.what == 2001) {
      d();
    }
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (paramMessage != null)
    {
      if ((paramMessage.obj instanceof VipBannerInfo))
      {
        paramMessage = (VipBannerInfo)paramMessage.obj;
        this.b = paramMessage;
        TianshuRenewalsBarManager.a((BaseActivity)this.f, paramBanner.c, paramMessage, BannerManager.a().c);
      }
    }
    else
    {
      if (paramBanner.c.getVisibility() == 8)
      {
        BannerManager.a().a(a, 0, null);
        this.b = null;
        return;
      }
      TianshuRenewalsBarManager.b((BaseActivity)this.f, paramBanner.c, this.b, BannerManager.a().c);
    }
  }
  
  public int b()
  {
    return a;
  }
  
  public void c()
  {
    BannerManager.a().a(a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.RenewalsBannerProcessor
 * JD-Core Version:    0.7.0.1
 */