package com.tencent.gdtad.aditem;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager;
import mqq.app.AppRuntime;

class GdtPreLoader$3
  implements Runnable
{
  GdtPreLoader$3(GdtPreLoader paramGdtPreLoader, GdtAd paramGdtAd) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    GdtLog.a("GdtPreLoader", "preloadVideoAfterAdLoaded() called with: app = [" + localAppRuntime + "]");
    if (localAppRuntime == null) {}
    ImaxAdVideoPreloadManager localImaxAdVideoPreloadManager;
    do
    {
      do
      {
        return;
      } while (!(localAppRuntime instanceof QQAppInterface));
      localImaxAdVideoPreloadManager = (ImaxAdVideoPreloadManager)localAppRuntime.getManager(QQManagerFactory.IMAX_AD_VIDEO_PRELOAD_MANAGER);
    } while (localImaxAdVideoPreloadManager == null);
    localImaxAdVideoPreloadManager.a(this.a.getTencent_video_id());
    localImaxAdVideoPreloadManager.a((QQAppInterface)localAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtPreLoader.3
 * JD-Core Version:    0.7.0.1
 */