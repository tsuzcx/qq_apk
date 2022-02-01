package com.tencent.mobileqq.app;

import android.os.Message;
import com.tencent.mobileqq.activity.recent.bannerprocessor.ThemeOverdueBannerProcessor;
import com.tencent.mobileqq.banner.BannerManager;

class ThemeHandler$2
  implements Runnable
{
  ThemeHandler$2(ThemeHandler paramThemeHandler, Message paramMessage) {}
  
  public void run()
  {
    BannerManager.a().a(ThemeOverdueBannerProcessor.a, 2, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThemeHandler.2
 * JD-Core Version:    0.7.0.1
 */