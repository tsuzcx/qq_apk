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
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class DonDisturbBannerProcessor
  extends BaseBannerProcessor
{
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
    paramBanner = new TipsBar(this.a);
    paramBanner.setTipsText(this.a.getString(2131699115));
    paramBanner.setTipsIcon(this.a.getResources().getDrawable(2130839417));
    paramBanner.setButtonText(HardCodeUtil.a(2131701001));
    paramBanner.a().setBackgroundResource(0);
    paramBanner.a().setTextColor(this.a.getResources().getColor(2131167041));
    paramBanner.setOriginalOnClickListener(new DonDisturbBannerProcessor.1(this));
    paramBanner.setOnClickListener(new DonDisturbBannerProcessor.2(this));
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (FriendsStatusUtil.a(this.a))
    {
      if (paramMessage == null) {
        return;
      }
      TipsBar localTipsBar = (TipsBar)paramBanner.a;
      if (paramMessage.arg1 == 2)
      {
        localTipsBar.setVisibility(0);
        ReportController.a(this.a.getAppRuntime(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 2, 0, "", "", "", "");
        return;
      }
      paramBanner.a.setVisibility(8);
      return;
    }
    paramBanner.a.setVisibility(8);
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    BannerManager.a().a(13, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.DonDisturbBannerProcessor
 * JD-Core Version:    0.7.0.1
 */