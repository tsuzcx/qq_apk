package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class DonDisturbBannerProcessor
  extends BaseBannerProcessor
{
  public static final int a = BannerTypeCollections.m;
  
  public DonDisturbBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = new TipsBar(this.f);
    paramBanner.setTipsText(this.f.getString(2131897235));
    paramBanner.setTipsIcon(this.f.getResources().getDrawable(2130839451));
    paramBanner.setButtonText(HardCodeUtil.a(2131899161));
    paramBanner.getButton().setBackgroundResource(0);
    paramBanner.getButton().setTextColor(this.f.getResources().getColor(2131168002));
    paramBanner.setOriginalOnClickListener(new DonDisturbBannerProcessor.1(this));
    paramBanner.setOnClickListener(new DonDisturbBannerProcessor.2(this));
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (FriendsStatusUtil.a(this.f))
    {
      if (paramMessage == null) {
        return;
      }
      TipsBar localTipsBar = (TipsBar)paramBanner.c;
      if (paramMessage.arg1 == 2)
      {
        localTipsBar.setVisibility(0);
        ReportController.a(this.f.getAppRuntime(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 2, 0, "", "", "", "");
        return;
      }
      paramBanner.c.setVisibility(8);
      return;
    }
    paramBanner.c.setVisibility(8);
  }
  
  public int b()
  {
    return a;
  }
  
  public void b(AppRuntime paramAppRuntime)
  {
    BannerManager.a().a(a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.DonDisturbBannerProcessor
 * JD-Core Version:    0.7.0.1
 */