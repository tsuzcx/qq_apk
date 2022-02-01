package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;

@KeepClassConstructor
public class NetStateBannerProcessor
  extends BaseBannerProcessor
{
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
    paramBanner = new TipsBar(this.a);
    paramBanner.setTipsText(this.a.getString(2131694462));
    paramBanner.setTipsIcon(this.a.getResources().getDrawable(2130838388));
    paramBanner.setOnClickListener(new NetStateBannerProcessor.1(this));
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner.a.setVisibility(0);
    ((TipsBar)paramBanner.a).setTipsText(this.a.getString(2131694462));
    if (BannerManager.a().a(14))
    {
      BannerManager.a().a(14, 0);
      BannerManager.a().b(31, 2003);
      BannerManager.a().b(14, 2004);
      BannerManager.a().b(14, 2001);
      BannerManager.a().b(14, 2000);
    }
    ReportController.a(this.a.getAppRuntime(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.NetStateBannerProcessor
 * JD-Core Version:    0.7.0.1
 */