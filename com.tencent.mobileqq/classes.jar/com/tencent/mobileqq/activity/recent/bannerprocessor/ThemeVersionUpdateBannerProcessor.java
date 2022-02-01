package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class ThemeVersionUpdateBannerProcessor
  extends BaseBannerProcessor
{
  public static final int a = BannerTypeCollections.B;
  
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
    paramBanner = new TipsBar(this.f);
    paramBanner.setTipsText(this.f.getString(2131888268));
    paramBanner.setTipsIcon(this.f.getResources().getDrawable(2130839452));
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (this.f == null) {
      return;
    }
    paramBanner.c.setVisibility(0);
    ((TipsBar)paramBanner.c).setTipsText(this.f.getString(2131888268));
    AppRuntime localAppRuntime;
    if (this.f != null) {
      localAppRuntime = this.f.getAppRuntime();
    } else {
      localAppRuntime = null;
    }
    if (localAppRuntime == null) {
      return;
    }
    if (paramMessage != null)
    {
      if (paramMessage.obj == null) {
        return;
      }
      paramMessage = (String)paramMessage.obj;
      ReportController.a(this.f.getAppRuntime(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 16, 0, "", "", "", "");
      paramBanner.c.setOnClickListener(new ThemeVersionUpdateBannerProcessor.1(this, paramMessage));
    }
  }
  
  public int b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ThemeVersionUpdateBannerProcessor
 * JD-Core Version:    0.7.0.1
 */