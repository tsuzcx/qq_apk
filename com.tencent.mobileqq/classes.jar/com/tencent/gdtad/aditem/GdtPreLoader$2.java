package com.tencent.gdtad.aditem;

import aail;
import aanp;
import astw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

public class GdtPreLoader$2
  implements Runnable
{
  public GdtPreLoader$2(aail paramaail, GdtAd paramGdtAd) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    aanp.a("GdtPreLoader", "preloadVideoAfterAdLoaded() called with: app = [" + localAppRuntime + "]");
    if (localAppRuntime == null) {}
    astw localastw;
    do
    {
      do
      {
        return;
      } while (!(localAppRuntime instanceof QQAppInterface));
      localastw = (astw)localAppRuntime.getManager(268);
    } while (localastw == null);
    localastw.a(this.a.getTencent_video_id());
    localastw.a((QQAppInterface)localAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtPreLoader.2
 * JD-Core Version:    0.7.0.1
 */