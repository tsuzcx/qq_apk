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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("preloadVideoAfterAdLoaded() called with: app = [");
    ((StringBuilder)localObject).append(localAppRuntime);
    ((StringBuilder)localObject).append("]");
    GdtLog.a("GdtPreLoader", ((StringBuilder)localObject).toString());
    if (localAppRuntime == null) {
      return;
    }
    if (!(localAppRuntime instanceof QQAppInterface)) {
      return;
    }
    localObject = (ImaxAdVideoPreloadManager)localAppRuntime.getManager(QQManagerFactory.IMAX_AD_VIDEO_PRELOAD_MANAGER);
    if (localObject == null) {
      return;
    }
    ((ImaxAdVideoPreloadManager)localObject).a(this.a.getTencent_video_id());
    ((ImaxAdVideoPreloadManager)localObject).a((QQAppInterface)localAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtPreLoader.3
 * JD-Core Version:    0.7.0.1
 */