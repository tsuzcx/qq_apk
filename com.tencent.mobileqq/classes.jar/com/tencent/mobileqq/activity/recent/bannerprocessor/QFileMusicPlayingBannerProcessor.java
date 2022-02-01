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
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class QFileMusicPlayingBannerProcessor
  extends BaseBannerProcessor
  implements IBannerLifecycle
{
  public QFileMusicPlayingBannerProcessor(QBaseActivity paramQBaseActivity)
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
    paramBanner.setOnClickListener(new QFileMusicPlayingBannerProcessor.1(this, paramBanner));
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if ((this.a != null) && (this.a.getAppRuntime() != null))
    {
      if (FileViewMusicService.a().a())
      {
        paramMessage = this.a.getString(2131694938);
        String str = FileViewMusicService.a().a();
        if (str != null)
        {
          ((TipsBar)paramBanner.a).setTipsText(paramMessage + "" + str);
          paramBanner.a.setVisibility(0);
          ReportController.a(this.a.getAppRuntime(), "dc00898", "", "", "0X8009EE1", "0X8009EE1", 2, 0, "", "", "", "");
          return;
        }
        paramBanner.a.setVisibility(8);
        return;
      }
      paramBanner.a.setVisibility(8);
      return;
    }
    paramBanner.a.setVisibility(8);
  }
  
  public void b()
  {
    BannerManager localBannerManager = BannerManager.a();
    if (FileViewMusicService.a().a()) {}
    for (int i = 2;; i = 0)
    {
      localBannerManager.a(44, i);
      return;
    }
  }
  
  public void b(AppRuntime paramAppRuntime) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.QFileMusicPlayingBannerProcessor
 * JD-Core Version:    0.7.0.1
 */