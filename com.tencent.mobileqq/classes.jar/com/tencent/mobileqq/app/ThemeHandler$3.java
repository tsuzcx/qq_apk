package com.tencent.mobileqq.app;

import com.tencent.mobileqq.activity.recent.bannerprocessor.ThemeVersionUpdateBannerProcessor;
import com.tencent.mobileqq.banner.BannerManager;

class ThemeHandler$3
  implements Runnable
{
  ThemeHandler$3(ThemeHandler paramThemeHandler) {}
  
  public void run()
  {
    BannerManager.a().a(ThemeVersionUpdateBannerProcessor.a, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThemeHandler.3
 * JD-Core Version:    0.7.0.1
 */