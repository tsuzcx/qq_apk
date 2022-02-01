package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class ZimuViewFactory
{
  public static ZimuView a(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, String paramString)
  {
    if (AudioHelper.e())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("create, id[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("ZimuViewFactory", 1, localStringBuilder.toString());
    }
    if ("ribbon".equals(paramString)) {
      paramVideoAppInterface = new ZimuViewRibon(paramLong, paramVideoAppInterface, paramContext, null);
    } else if ("pacman".equals(paramString)) {
      paramVideoAppInterface = new ZimuViewPacMan(paramLong, paramVideoAppInterface, paramContext, null);
    } else if ("film".equals(paramString)) {
      paramVideoAppInterface = new ZimuViewFilm(paramLong, paramVideoAppInterface, paramContext, null);
    } else {
      paramVideoAppInterface = null;
    }
    if (paramVideoAppInterface != null) {
      paramVideoAppInterface.b();
    }
    return paramVideoAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewFactory
 * JD-Core Version:    0.7.0.1
 */