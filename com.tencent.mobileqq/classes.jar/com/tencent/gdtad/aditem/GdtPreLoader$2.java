package com.tencent.gdtad.aditem;

import ardi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;
import ysu;
import yxp;

public class GdtPreLoader$2
  implements Runnable
{
  public GdtPreLoader$2(ysu paramysu, GdtAd paramGdtAd) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    yxp.a("GdtPreLoader", "preloadVideoAfterAdLoaded() called with: app = [" + localAppRuntime + "]");
    if (localAppRuntime == null) {}
    ardi localardi;
    do
    {
      do
      {
        return;
      } while (!(localAppRuntime instanceof QQAppInterface));
      localardi = (ardi)localAppRuntime.getManager(268);
    } while (localardi == null);
    localardi.a(this.a.getTencent_video_id());
    localardi.a((QQAppInterface)localAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtPreLoader.2
 * JD-Core Version:    0.7.0.1
 */