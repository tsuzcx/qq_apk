package com.tencent.gdtad.aditem;

import acam;
import acho;
import avqv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import mqq.app.AppRuntime;

public class GdtPreLoader$3
  implements Runnable
{
  public GdtPreLoader$3(acam paramacam, GdtAd paramGdtAd) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    acho.a("GdtPreLoader", "preloadVideoAfterAdLoaded() called with: app = [" + localAppRuntime + "]");
    if (localAppRuntime == null) {}
    avqv localavqv;
    do
    {
      do
      {
        return;
      } while (!(localAppRuntime instanceof QQAppInterface));
      localavqv = (avqv)localAppRuntime.getManager(QQManagerFactory.IMAX_AD_VIDEO_PRELOAD_MANAGER);
    } while (localavqv == null);
    localavqv.a(this.a.getTencent_video_id());
    localavqv.a((QQAppInterface)localAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtPreLoader.3
 * JD-Core Version:    0.7.0.1
 */