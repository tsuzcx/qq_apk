package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
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
    paramBanner = new TipsBar(this.a);
    paramBanner.setTipsText(this.a.getString(2131694462));
    paramBanner.setTipsIcon(this.a.getResources().getDrawable(2130838388));
    paramBanner.setOnClickListener(new IllegalNetworkBannerProcessor.1(this));
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner.a.setVisibility(0);
    ((TipsBar)paramBanner.a).setTipsText(this.a.getString(2131691160));
  }
  
  public void b()
  {
    boolean bool = LoadingStateManager.a().d();
    BannerManager localBannerManager = BannerManager.a();
    if (bool) {}
    for (int i = 2;; i = 0)
    {
      localBannerManager.a(12, i);
      LoadingStateManager.a().b(bool);
      return;
    }
  }
  
  public void b(AppRuntime paramAppRuntime) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.IllegalNetworkBannerProcessor
 * JD-Core Version:    0.7.0.1
 */