package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Message;
import android.text.Html;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;

@KeepClassConstructor
public class MusicPlayerBannerProcessor
  extends BaseBannerProcessor
{
  public MusicPlayerBannerProcessor(QBaseActivity paramQBaseActivity)
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
    paramBanner.setTipsIcon(this.a.getResources().getDrawable(2130841483));
    paramBanner.setOnClickListener(new MusicPlayerBannerProcessor.1(this));
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (QQPlayerService.a())
    {
      paramBanner.a.setVisibility(0);
      paramMessage = QQPlayerService.b();
      if (paramMessage != null)
      {
        String str = this.a.getString(2131694938);
        ((TipsBar)paramBanner.a).setTipsText(Html.fromHtml(str + " " + paramMessage.c));
      }
      ReportController.a(this.a.getAppRuntime(), "dc00898", "", "", "0X8009EE0", "0X8009EE0", 1, 0, "", "", "", "");
      return;
    }
    paramBanner.a.setVisibility(8);
    BannerManager.a().a(41, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.MusicPlayerBannerProcessor
 * JD-Core Version:    0.7.0.1
 */