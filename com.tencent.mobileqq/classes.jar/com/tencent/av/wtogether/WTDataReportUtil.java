package com.tencent.av.wtogether;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.av.wtogether.data.WTFileInfo;
import com.tencent.av.wtogether.data.WTogetherPlayInfo;
import com.tencent.av.wtogether.data.WatchTogetherInfo;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.av.wtogether.util.WatchTogetherDataReportHelper;
import com.tencent.av.wtogether.util.WatchTogetherDataReportHelper.WTFilePlayInfo;
import com.tencent.qphone.base.util.QLog;

public class WTDataReportUtil
{
  private static int a;
  private static long b;
  private static long c;
  private static String d;
  
  public static String a(WTogetherPlayInfo paramWTogetherPlayInfo)
  {
    if ((paramWTogetherPlayInfo != null) && (paramWTogetherPlayInfo.a != null)) {
      return paramWTogetherPlayInfo.a.e();
    }
    return null;
  }
  
  public static void a()
  {
    b = SystemClock.elapsedRealtime();
    c = 0L;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnterWTRoom, start[");
      localStringBuilder.append(b);
      localStringBuilder.append("]");
      QLog.i("WTDataReportUtil", 2, localStringBuilder.toString());
    }
  }
  
  public static void a(WTogetherPlayInfo paramWTogetherPlayInfo, long paramLong)
  {
    if (paramWTogetherPlayInfo != null)
    {
      if (paramWTogetherPlayInfo.a == null) {
        return;
      }
      if (!TextUtils.isEmpty(d)) {
        a(paramWTogetherPlayInfo, "onPlayStart");
      }
      a += 1;
      d = a(paramWTogetherPlayInfo);
      int i = paramWTogetherPlayInfo.a.b();
      String str1 = String.valueOf(paramLong / 1000L);
      String str2 = c();
      String str3 = paramWTogetherPlayInfo.a.c();
      String str4 = paramWTogetherPlayInfo.a.d();
      AVUtil.a("0X800B62E", i, 0, str1, str2, str3, str4);
      if (paramWTogetherPlayInfo.a.a == 4) {
        AVUtil.a("0X800B8DF", 1, 0, paramWTogetherPlayInfo.a.i, "", paramWTogetherPlayInfo.a.l, paramWTogetherPlayInfo.a.g);
      } else if (paramWTogetherPlayInfo.a.a == 3) {
        AVUtil.a("0X800B8DF", 1, 0, paramWTogetherPlayInfo.a.i, "", paramWTogetherPlayInfo.a.h, paramWTogetherPlayInfo.a.g);
      }
      if (QLog.isColorLevel())
      {
        paramWTogetherPlayInfo = new StringBuilder();
        paramWTogetherPlayInfo.append("onPlayStart, key[");
        paramWTogetherPlayInfo.append(d);
        paramWTogetherPlayInfo.append("], from[");
        paramWTogetherPlayInfo.append(i);
        paramWTogetherPlayInfo.append("], r2[");
        paramWTogetherPlayInfo.append(str1);
        paramWTogetherPlayInfo.append("], r3[");
        paramWTogetherPlayInfo.append(str2);
        paramWTogetherPlayInfo.append("], r4[");
        paramWTogetherPlayInfo.append(str3);
        paramWTogetherPlayInfo.append("], r5[");
        paramWTogetherPlayInfo.append(str4);
        paramWTogetherPlayInfo.append("]");
        QLog.i("WTDataReportUtil", 2, paramWTogetherPlayInfo.toString());
      }
    }
  }
  
  public static void a(WTogetherPlayInfo paramWTogetherPlayInfo, String paramString)
  {
    String str1 = a(paramWTogetherPlayInfo);
    if ((str1 != null) && (TextUtils.equals(str1, d)))
    {
      Object localObject1 = VideoController.f().aA();
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((WatchTogetherMediaPlayCtrl)localObject1).m();
      }
      if (localObject1 == null) {
        localObject2 = null;
      } else {
        localObject2 = ((WatchTogetherDataReportHelper)localObject1).a(str1);
      }
      long l1 = 0L;
      long l2;
      if (localObject2 != null)
      {
        l1 = ((WatchTogetherDataReportHelper.WTFilePlayInfo)localObject2).b;
        l2 = ((WatchTogetherDataReportHelper.WTFilePlayInfo)localObject2).c;
      }
      else
      {
        l2 = 0L;
      }
      int i = 0;
      Object localObject2 = String.valueOf(l1 / 1000L);
      String str2 = String.valueOf(l2 / 1000L);
      if (paramWTogetherPlayInfo.a != null)
      {
        int j = paramWTogetherPlayInfo.a.b();
        if (paramWTogetherPlayInfo.a.a == 4)
        {
          AVUtil.a("0X800B8E0", 1, 0, paramWTogetherPlayInfo.a.i, str2, paramWTogetherPlayInfo.a.l, paramWTogetherPlayInfo.a.g);
          i = j;
        }
        else
        {
          i = j;
          if (paramWTogetherPlayInfo.a.a == 3)
          {
            AVUtil.a("0X800B8E0", 1, 0, paramWTogetherPlayInfo.a.i, str2, paramWTogetherPlayInfo.a.h, paramWTogetherPlayInfo.a.g);
            i = j;
          }
        }
      }
      AVUtil.a("0X800B639", i, 0, (String)localObject2, str2, c(), "");
      c += l2;
      d = null;
      if (localObject1 != null) {
        ((WatchTogetherDataReportHelper)localObject1).b(str1);
      }
      if (QLog.isColorLevel())
      {
        paramWTogetherPlayInfo = new StringBuilder();
        paramWTogetherPlayInfo.append("onPlayEnd, from[");
        paramWTogetherPlayInfo.append(paramString);
        paramWTogetherPlayInfo.append("], key[");
        paramWTogetherPlayInfo.append(str1);
        paramWTogetherPlayInfo.append("], fromType[");
        paramWTogetherPlayInfo.append(i);
        paramWTogetherPlayInfo.append("], r2[");
        paramWTogetherPlayInfo.append((String)localObject2);
        paramWTogetherPlayInfo.append("], r3[");
        paramWTogetherPlayInfo.append(str2);
        paramWTogetherPlayInfo.append("]");
        QLog.i("WTDataReportUtil", 2, paramWTogetherPlayInfo.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramWTogetherPlayInfo = new StringBuilder();
      paramWTogetherPlayInfo.append("onPlayEnd, from[");
      paramWTogetherPlayInfo.append(paramString);
      paramWTogetherPlayInfo.append("], report before.");
      QLog.i("WTDataReportUtil", 2, paramWTogetherPlayInfo.toString());
    }
  }
  
  public static void b()
  {
    long l;
    if (b != 0L) {
      l = Math.abs(SystemClock.elapsedRealtime() - b);
    } else {
      l = 0L;
    }
    int i = a;
    String str1 = String.valueOf(l / 1000L);
    String str2 = String.valueOf(c / 1000L);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("");
    AVUtil.a("0X800B6C0", 0, 0, str1, str2, localStringBuilder.toString(), "");
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onExitWTRoom, r2[");
      localStringBuilder.append(str1);
      localStringBuilder.append("], r3[");
      localStringBuilder.append(str2);
      localStringBuilder.append("], count[");
      localStringBuilder.append(i);
      localStringBuilder.append("]");
      QLog.i("WTDataReportUtil", 2, localStringBuilder.toString());
    }
    c = 0L;
    b = 0L;
    a = 0;
  }
  
  public static String c()
  {
    Object localObject = (WTogetherMng)VideoController.f().aj().c(17);
    if (localObject != null)
    {
      localObject = ((WTogetherMng)localObject).b(VideoController.f().k());
      if ((localObject != null) && (((WatchTogetherInfo)localObject).f != null)) {
        return ((WatchTogetherInfo)localObject).f.e();
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.WTDataReportUtil
 * JD-Core Version:    0.7.0.1
 */