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
  public static final int a = BannerTypeCollections.a;
  
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
    paramBanner = new TipsBar(this.f);
    paramBanner.setTipsText(this.f.getString(2131892107));
    paramBanner.setTipsIcon(this.f.getResources().getDrawable(2130839452));
    paramBanner.setOnClickListener(new NetStateBannerProcessor.1(this));
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner.c.setVisibility(0);
    ((TipsBar)paramBanner.c).setTipsText(this.f.getString(2131892107));
    if (BannerManager.a().c(PCOnlineBannerProcessor.a))
    {
      BannerManager.a().a(PCOnlineBannerProcessor.a, 0);
      BannerManager.a().b(LoginDevicesBannerProcessor.a, 2003);
      BannerManager.a().b(PCOnlineBannerProcessor.a, 2004);
      BannerManager.a().b(PCOnlineBannerProcessor.a, 2001);
      BannerManager.a().b(PCOnlineBannerProcessor.a, 2000);
    }
    ReportController.a(this.f.getAppRuntime(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 1, 0, "", "", "", "");
  }
  
  public int b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.NetStateBannerProcessor
 * JD-Core Version:    0.7.0.1
 */