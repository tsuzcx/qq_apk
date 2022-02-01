package com.tencent.gdtad.aditem;

import abkw;
import abrl;
import aula;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

public class GdtPreLoader$3
  implements Runnable
{
  public GdtPreLoader$3(abkw paramabkw, GdtAd paramGdtAd) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    abrl.a("GdtPreLoader", "preloadVideoAfterAdLoaded() called with: app = [" + localAppRuntime + "]");
    if (localAppRuntime == null) {}
    aula localaula;
    do
    {
      do
      {
        return;
      } while (!(localAppRuntime instanceof QQAppInterface));
      localaula = (aula)localAppRuntime.getManager(268);
    } while (localaula == null);
    localaula.a(this.a.getTencent_video_id());
    localaula.a((QQAppInterface)localAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtPreLoader.3
 * JD-Core Version:    0.7.0.1
 */