package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;

public class ZimuViewFactory
{
  public static ZimuView a(VideoAppInterface paramVideoAppInterface, Context paramContext, String paramString)
  {
    AVLog.c("ZimuViewFactory", "ZimuViewFactory: " + paramString);
    if ("ribbon".equals(paramString)) {
      paramVideoAppInterface = new ZimuViewRibon(paramVideoAppInterface, paramContext, null);
    }
    for (;;)
    {
      if (paramVideoAppInterface != null) {
        paramVideoAppInterface.b();
      }
      return paramVideoAppInterface;
      if ("pacman".equals(paramString)) {
        paramVideoAppInterface = new ZimuViewPacMan(paramVideoAppInterface, paramContext, null);
      } else if ("film".equals(paramString)) {
        paramVideoAppInterface = new ZimuViewFilm(paramVideoAppInterface, paramContext, null);
      } else if ("liveshow".equals(paramString)) {
        paramVideoAppInterface = new ZimuViewLive(paramVideoAppInterface, paramContext, null);
      } else {
        paramVideoAppInterface = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewFactory
 * JD-Core Version:    0.7.0.1
 */