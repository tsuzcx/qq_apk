package com.tencent.common.danmaku.util;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.common.danmaku.DanmakuDependImp;
import com.tencent.common.danmaku.IDanmakuDepend;
import com.tencent.common.danmaku.data.BaseDanmaku;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

public class DanmakuUtils
{
  private static final SimpleDateFormat a = new SimpleDateFormat("yy年M月d日 hh:mm:ss");
  private static final Date b = new Date();
  private static final StringBuilder c = new StringBuilder();
  private static final Formatter d = new Formatter(c, Locale.getDefault());
  private static float e = -1.0F;
  
  public static int a(float paramFloat)
  {
    if (e < 0.0F) {
      e = DanmakuDependImp.a().b().b().getDisplayMetrics().density;
    }
    return (int)(paramFloat * e + 0.5F);
  }
  
  public static int a(BaseDanmaku paramBaseDanmaku1, BaseDanmaku paramBaseDanmaku2)
  {
    if (paramBaseDanmaku1 == paramBaseDanmaku2) {
      return 0;
    }
    if (paramBaseDanmaku1 == null) {
      return -1;
    }
    if (paramBaseDanmaku2 == null) {
      return 1;
    }
    if (paramBaseDanmaku1.equals(paramBaseDanmaku2)) {
      return 0;
    }
    long l = paramBaseDanmaku1.x() - paramBaseDanmaku2.x();
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    int i = paramBaseDanmaku1.y() - paramBaseDanmaku2.y();
    if (i > 0) {
      return -1;
    }
    if (i < 0) {
      return 1;
    }
    i = paramBaseDanmaku1.D() - paramBaseDanmaku2.D();
    if (i > 0) {
      return 1;
    }
    if (i < 0) {
      return -1;
    }
    i = paramBaseDanmaku1.z() - paramBaseDanmaku2.z();
    if (i > 0) {
      return -1;
    }
    if (i < 0) {
      return 1;
    }
    l = paramBaseDanmaku1.w() - paramBaseDanmaku2.w();
    if (l > 0L) {
      return -1;
    }
    if (l < 0L) {
      return 1;
    }
    i = paramBaseDanmaku1.q() - paramBaseDanmaku2.q();
    if (i > 0) {
      return 1;
    }
    if (i < 0) {
      return -1;
    }
    return i;
  }
  
  public static int a(BaseDanmaku paramBaseDanmaku1, BaseDanmaku paramBaseDanmaku2, long paramLong)
  {
    if (!paramBaseDanmaku1.b(paramLong))
    {
      if (paramBaseDanmaku2.b(paramLong)) {
        return -1;
      }
      float[] arrayOfFloat1 = paramBaseDanmaku1.e(paramBaseDanmaku1.Q());
      float[] arrayOfFloat2 = paramBaseDanmaku2.e(paramBaseDanmaku1.Q());
      if (arrayOfFloat1 != null)
      {
        if (arrayOfFloat2 == null) {
          return -1;
        }
        int j = (int)((arrayOfFloat2[0] - arrayOfFloat1[2]) / paramBaseDanmaku2.i());
        arrayOfFloat1 = paramBaseDanmaku1.e(paramBaseDanmaku1.l());
        paramBaseDanmaku1 = paramBaseDanmaku2.e(paramBaseDanmaku1.l());
        int i = j;
        if (arrayOfFloat1 != null)
        {
          i = j;
          if (paramBaseDanmaku1 != null) {
            i = Math.max(j, (int)((paramBaseDanmaku1[0] - arrayOfFloat1[2]) / paramBaseDanmaku2.i()));
          }
        }
        return i;
      }
    }
    return -1;
  }
  
  public static String a(long paramLong)
  {
    if (paramLong < 86400000L)
    {
      paramLong /= 1000L;
      long l1 = paramLong % 60L;
      long l2 = paramLong / 60L % 60L;
      long l3 = paramLong / 3600L;
      paramLong = l1;
      if (l1 < 0L) {
        paramLong = 0L;
      }
      l1 = l2;
      if (l2 < 0L) {
        l1 = 0L;
      }
      l2 = l3;
      if (l3 < 0L) {
        l2 = 0L;
      }
      c.setLength(0);
      if (l2 > 0L) {
        return d.format("%d:%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
      }
      return d.format("%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
    }
    b.setTime(paramLong);
    return a.format(b);
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 18;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.util.DanmakuUtils
 * JD-Core Version:    0.7.0.1
 */