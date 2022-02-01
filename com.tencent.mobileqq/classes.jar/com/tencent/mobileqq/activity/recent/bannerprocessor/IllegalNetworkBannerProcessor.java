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
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class IllegalNetworkBannerProcessor
  extends BaseBannerProcessor
  implements IBannerLifecycle
{
  public static final int a = BannerTypeCollections.l;
  
  public IllegalNetworkBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public int a()
  {
    return 4;
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = new TipsBar(this.f);
    paramBanner.setTipsText(this.f.getString(2131892107));
    paramBanner.setTipsIcon(this.f.getResources().getDrawable(2130839452));
    paramBanner.setOnClickListener(new IllegalNetworkBannerProcessor.1(this));
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner.c.setVisibility(0);
    ((TipsBar)paramBanner.c).setTipsText(this.f.getString(2131888026));
  }
  
  public void a(AppRuntime paramAppRuntime) {}
  
  public int b()
  {
    return a;
  }
  
  public void d()
  {
    boolean bool = LoadingStateManager.b().e();
    BannerManager localBannerManager = BannerManager.a();
    int j = a;
    int i;
    if (bool) {
      i = 2;
    } else {
      i = 0;
    }
    localBannerManager.a(j, i);
    LoadingStateManager.b().b(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.IllegalNetworkBannerProcessor
 * JD-Core Version:    0.7.0.1
 */