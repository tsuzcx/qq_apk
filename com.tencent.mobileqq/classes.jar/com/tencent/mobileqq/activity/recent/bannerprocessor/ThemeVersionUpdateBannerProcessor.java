package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class ThemeVersionUpdateBannerProcessor
  extends BaseBannerProcessor
{
  public ThemeVersionUpdateBannerProcessor(QBaseActivity paramQBaseActivity)
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
    paramBanner.setTipsText(this.a.getString(2131691391));
    paramBanner.setTipsIcon(this.a.getResources().getDrawable(2130838388));
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      paramBanner.a.setVisibility(0);
      ((TipsBar)paramBanner.a).setTipsText(this.a.getString(2131691391));
      if (this.a != null) {}
      for (AppRuntime localAppRuntime = this.a.getAppRuntime(); (localAppRuntime != null) && (paramMessage != null) && (paramMessage.obj != null); localAppRuntime = null)
      {
        paramMessage = (String)paramMessage.obj;
        ReportController.a(this.a.getAppRuntime(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 16, 0, "", "", "", "");
        paramBanner.a.setOnClickListener(new ThemeVersionUpdateBannerProcessor.1(this, paramMessage));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ThemeVersionUpdateBannerProcessor
 * JD-Core Version:    0.7.0.1
 */