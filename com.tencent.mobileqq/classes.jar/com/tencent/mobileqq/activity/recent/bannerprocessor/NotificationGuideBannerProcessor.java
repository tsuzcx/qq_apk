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
  public static final int a = BannerTypeCollections.v;
  
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
    paramBanner = new AdvancedTipsBar(this.f);
    NotificationBannerManager.a((QQAppInterface)this.f.getAppRuntime()).a(BannerManager.a(), (BaseActivity)this.f, paramBanner);
    return paramBanner;
  }
  
  public void a(Message paramMessage, long paramLong, boolean paramBoolean)
  {
    if (paramMessage.what == 3000) {
      NotificationBannerManager.a((QQAppInterface)this.f.getAppRuntime()).a(BannerManager.a(), paramMessage);
    }
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    NotificationBannerManager.a((QQAppInterface)this.f.getAppRuntime()).a(BannerManager.a(), paramBanner.c);
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
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.NotificationGuideBannerProcessor
 * JD-Core Version:    0.7.0.1
 */