package com.tencent.gdtad.aditem;

import acoo;
import acvc;
import avya;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

public class GdtPreLoader$3
  implements Runnable
{
  public GdtPreLoader$3(acoo paramacoo, GdtAd paramGdtAd) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    acvc.a("GdtPreLoader", "preloadVideoAfterAdLoaded() called with: app = [" + localAppRuntime + "]");
    if (localAppRuntime == null) {}
    avya localavya;
    do
    {
      do
      {
        return;
      } while (!(localAppRuntime instanceof QQAppInterface));
      localavya = (avya)localAppRuntime.getManager(268);
    } while (localavya == null);
    localavya.a(this.a.getTencent_video_id());
    localavya.a((QQAppInterface)localAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtPreLoader.3
 * JD-Core Version:    0.7.0.1
 */