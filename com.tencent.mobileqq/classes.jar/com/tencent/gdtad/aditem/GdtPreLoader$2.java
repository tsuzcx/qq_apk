package com.tencent.gdtad.aditem;

import aqjb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;
import yju;
import yny;

public class GdtPreLoader$2
  implements Runnable
{
  public GdtPreLoader$2(yju paramyju, GdtAd paramGdtAd) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    yny.a("GdtPreLoader", "preloadVideoAfterAdLoaded() called with: app = [" + localAppRuntime + "]");
    if (localAppRuntime == null) {}
    aqjb localaqjb;
    do
    {
      do
      {
        return;
      } while (!(localAppRuntime instanceof QQAppInterface));
      localaqjb = (aqjb)localAppRuntime.getManager(268);
    } while (localaqjb == null);
    localaqjb.a(this.a.getTencent_video_id());
    localaqjb.a((QQAppInterface)localAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtPreLoader.2
 * JD-Core Version:    0.7.0.1
 */