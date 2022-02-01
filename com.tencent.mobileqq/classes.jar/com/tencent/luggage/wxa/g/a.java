package com.tencent.luggage.wxa.g;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.graphics.Point;
import com.tencent.luggage.wxa.f.f;
import com.tencent.luggage.wxa.f.q;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class a
{
  public static int a(int paramInt)
  {
    return a(paramInt, 2147483647);
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 % 16;
    if (i == 0) {
      return paramInt1;
    }
    int j = 16 - i + paramInt1;
    if (j < paramInt2) {
      return j;
    }
    return paramInt1 - i;
  }
  
  public static long a(Context paramContext)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null) {
      return 0L;
    }
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    paramContext.getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.availMem / 1024L / 1024L;
  }
  
  public static Point a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      float f;
      if (paramInt3 != 90)
      {
        f = paramFloat;
        if (paramInt3 != 270) {}
      }
      else
      {
        f = 1.0F / paramFloat;
      }
      int i;
      if (paramInt2 * f < paramInt1) {
        i = 1;
      } else {
        i = 0;
      }
      paramFloat = 1.0F / f;
      if (i == 0)
      {
        paramInt1 = Math.max(paramInt2, paramInt1);
        paramInt2 = (int)(paramInt1 * paramFloat);
        if ((paramInt3 != 90) && (paramInt3 != 270)) {
          return new Point(paramInt1, paramInt2);
        }
        return new Point(paramInt2, paramInt1);
      }
      paramInt1 = Math.min(paramInt2, paramInt1);
      paramInt2 = (int)(paramInt1 / paramFloat);
      if ((paramInt3 != 90) && (paramInt3 != 270)) {
        return new Point(paramInt2, paramInt1);
      }
      return new Point(paramInt1, paramInt2);
    }
    return null;
  }
  
  public static Point a(Point paramPoint1, Point paramPoint2, boolean paramBoolean)
  {
    return a(paramPoint1, paramPoint2, paramBoolean, false);
  }
  
  public static Point a(Point paramPoint1, Point paramPoint2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = paramPoint2.x;
    int m = paramPoint2.y;
    if (paramBoolean1) {
      i = paramPoint1.y;
    } else {
      i = paramPoint1.x;
    }
    if (paramBoolean1) {
      j = paramPoint1.x;
    } else {
      j = paramPoint1.y;
    }
    float f2 = -1.0F;
    float f1 = f2;
    if (k < i)
    {
      f1 = f2;
      if (m < j) {
        f1 = m * 1.0F / j;
      }
    }
    if (f1 > 0.0F) {
      j = Math.round(i * f1);
    } else {
      j = (int)(m * (i / j));
    }
    int i = j;
    if (j % 2 != 0) {
      i = j + 1;
    }
    int j = i;
    if (paramBoolean2) {
      j = a(i, paramPoint2.y);
    }
    f.a("MicroMsg.CameraSizeUtil", "getCropPreviewSizeWithHeight, previewSize: %s, displaySize: %s, width: %s, newWidth: %s, makeMediaCodecHappy %s, , isRoate: %s", new Object[] { paramPoint2, paramPoint1, Integer.valueOf(k), Integer.valueOf(j), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
    if ((j > paramPoint2.x) && (f1 <= 0.0F))
    {
      f.b("MicroMsg.CameraSizeUtil", "can not adapt to screen");
      return null;
    }
    return new Point(j, m);
  }
  
  private static Point a(List<q> paramList, Point paramPoint, boolean paramBoolean, int paramInt)
  {
    int i = paramPoint.x;
    int j = paramPoint.y * paramInt;
    if (j % i != 0) {
      return null;
    }
    i = j / i;
    if (paramBoolean)
    {
      j = paramInt ^ i;
      i ^= j;
      j ^= i;
    }
    else
    {
      j = paramInt;
    }
    paramList = paramList.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      paramPoint = (q)paramList.next();
      if ((paramPoint.a() == j) && (paramPoint.b() == i))
      {
        f.a("MicroMsg.CameraSizeUtil", "findEqualsPrewviewSize FindBestSize %d %d", Integer.valueOf(j), Integer.valueOf(i));
        return new Point(j, i);
      }
    } while (Math.min(paramPoint.a(), paramPoint.b()) >= paramInt);
    return null;
  }
  
  public static a.b a(Context paramContext, List<q> paramList, Point paramPoint, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramList == null) {
      return null;
    }
    Collections.sort(paramList, new a.a(null));
    f.b("MicroMsg.CameraSizeUtil", "supportedPreviewSizes: %s", a(paramList));
    float f = paramPoint.x / paramPoint.y;
    int i = paramPoint.x;
    int j = 0;
    f.a("MicroMsg.CameraSizeUtil", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewview: %s lowerBoundPreView: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramPoint.y), Float.valueOf(f), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    f.a("MicroMsg.CameraSizeUtil", "systemAvailableMemInMB: %d", Long.valueOf(a(paramContext)));
    paramContext = new a.b();
    paramContext.a = a(paramList, paramPoint, paramBoolean, paramInt1);
    if (paramContext.a != null)
    {
      paramContext.b = b(paramPoint, paramContext.a, paramBoolean);
      paramContext.c = b(paramPoint, paramContext.a, paramBoolean, true);
      i = j;
    }
    else
    {
      Point localPoint = new Point();
      paramList = paramList.iterator();
      Object localObject;
      do
      {
        for (;;)
        {
          i = j;
          if (!paramList.hasNext()) {
            break label569;
          }
          localObject = (q)paramList.next();
          localPoint.x = ((q)localObject).a();
          localPoint.y = ((q)localObject).b();
          if (localPoint.x == localPoint.y)
          {
            f.b("MicroMsg.CameraSizeUtil", "exclude square curSize: %s", localPoint);
          }
          else
          {
            StringBuilder localStringBuilder;
            if (paramPoint.y > paramPoint.x)
            {
              if (localPoint.y >= localPoint.x)
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("screen ratio is differ from preview ratio and unSupport preview is ");
                localStringBuilder.append(localObject);
                f.b("MicroMsg.CameraSizeUtil", localStringBuilder.toString());
              }
            }
            else if (localPoint.y <= localPoint.x)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("screen ratio is differ from preview ratio and unSupport preview is ");
              localStringBuilder.append(localObject);
              f.b("MicroMsg.CameraSizeUtil", localStringBuilder.toString());
              continue;
            }
            localObject = b(paramPoint, localPoint, paramBoolean);
            if (localObject != null) {
              break;
            }
            f.b("MicroMsg.CameraSizeUtil", "curSize: %s, can not find crop size", localPoint);
          }
        }
        f.a("MicroMsg.CameraSizeUtil", "preViewPoint: %s --> bestSize %s ", localPoint, localObject);
        paramContext.e = new Point(((Point)localObject).x, ((Point)localObject).y);
        paramContext.d = new Point(localPoint.x, localPoint.y);
        paramContext.f = b(paramPoint, localPoint, paramBoolean, true);
      } while (Math.min(((Point)localObject).x, ((Point)localObject).y) > paramInt1);
      if (Math.min(((Point)localObject).x, ((Point)localObject).y) < paramInt2) {
        return null;
      }
      paramList = new Point(localPoint.x, localPoint.y);
      paramContext.a = paramList;
      paramContext.b = ((Point)localObject);
      paramContext.c = b(paramPoint, paramContext.a, paramBoolean, true);
      f.a("MicroMsg.CameraSizeUtil", "find bestPreviewSize  %s -> %s findcount %d", paramList, localObject, Integer.valueOf(1));
      i = 1;
    }
    label569:
    f.a("MicroMsg.CameraSizeUtil", "final tryFindBestSize PrewviewSize %s cropSize %s findcount %d", paramContext.a, paramContext.b, Integer.valueOf(i));
    return paramContext;
  }
  
  public static a.b a(Context paramContext, List<q> paramList, Point paramPoint, int paramInt, boolean paramBoolean)
  {
    if (paramList == null) {
      return null;
    }
    return a(paramContext, paramList, paramPoint, paramInt, 0, paramBoolean);
  }
  
  private static String a(List<q> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      q localq = (q)paramList.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("size: ");
      localStringBuilder.append(localq.b());
      localStringBuilder.append(",");
      localStringBuilder.append(localq.a());
      localStringBuilder.append(" ");
      double d1 = localq.b();
      Double.isNaN(d1);
      double d2 = localq.a();
      Double.isNaN(d2);
      localStringBuilder.append(d1 * 1.0D / d2);
      localStringBuilder.append("||");
      localStringBuffer.append(localStringBuilder.toString());
    }
    return localStringBuffer.toString();
  }
  
  public static Point b(Point paramPoint1, Point paramPoint2, boolean paramBoolean)
  {
    return b(paramPoint1, paramPoint2, paramBoolean, false);
  }
  
  public static Point b(Point paramPoint1, Point paramPoint2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = paramPoint2.x;
    int m = paramPoint2.y;
    if (paramBoolean1) {
      i = paramPoint1.y;
    } else {
      i = paramPoint1.x;
    }
    if (paramBoolean1) {
      j = paramPoint1.x;
    } else {
      j = paramPoint1.y;
    }
    float f1 = k;
    float f2 = j;
    float f3 = i;
    int j = (int)(f1 * (f2 / f3));
    int i = j;
    if (j % 2 != 0) {
      i = j - 1;
    }
    m = (int)(m * (f3 / f2));
    j = i;
    if (paramBoolean2) {
      j = a(i, paramPoint2.y);
    }
    f.a("MicroMsg.CameraSizeUtil", "getCropPreviewSizeWithHeight, previewSize: %s, displaySize: %s, width: %s, newHeight: %s makeMediaCodecHappy %s, newWidth: %s, isRoate: %s", new Object[] { paramPoint2, paramPoint1, Integer.valueOf(k), Integer.valueOf(j), Boolean.valueOf(paramBoolean2), Integer.valueOf(m), Boolean.valueOf(paramBoolean1) });
    if ((j <= paramPoint2.y) && (k <= paramPoint2.x)) {
      return new Point(k, j);
    }
    f.b("MicroMsg.CameraSizeUtil", "can not adapt to screen");
    return null;
  }
  
  public static a.b b(Context paramContext, List<q> paramList, Point paramPoint, int paramInt, boolean paramBoolean)
  {
    if (paramList == null) {
      return null;
    }
    Collections.sort(paramList, new a.a(null));
    f.b("MicroMsg.CameraSizeUtil", "tryFindPreviewSizeAnyWay supportedPreviewSizes: %s", a(paramList));
    float f = paramPoint.x / paramPoint.y;
    f.a("MicroMsg.CameraSizeUtil", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewview: %s", Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f), Integer.valueOf(paramInt));
    f.a("MicroMsg.CameraSizeUtil", "systemAvailableMemInMB: %d", Long.valueOf(a(paramContext)));
    paramContext = new a.b();
    paramContext.a = a(paramList, paramPoint, paramBoolean, paramInt);
    if (paramContext.a != null)
    {
      paramContext.b = a(paramPoint, paramContext.a, paramBoolean);
      paramContext.c = a(paramPoint, paramContext.a, paramBoolean, true);
    }
    else
    {
      Point localPoint = new Point();
      Math.min(paramPoint.x, paramPoint.y);
      Math.max(paramPoint.x, paramPoint.y);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        q localq = (q)paramList.next();
        localPoint.x = localq.a();
        localPoint.y = localq.b();
        if ((localPoint.x != localPoint.y) && (Math.min(localPoint.x, localPoint.y) <= paramInt) && (Math.max(localPoint.x, localPoint.y) <= 2000) && (a(paramPoint, localPoint, paramBoolean) != null)) {
          paramContext.a = new Point(localq.a(), localq.b());
        }
      }
    }
    f.a("MicroMsg.CameraSizeUtil", "final tryFindBestSize PrewviewSize %s cropSize %s findcount %d with any way", paramContext.a, paramContext.b, Integer.valueOf(0));
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.g.a
 * JD-Core Version:    0.7.0.1
 */