package com.tencent.av.wtogether.data;

import com.tencent.qphone.base.util.QLog;

public class WTogetherPlayInfo
{
  public final WTFileInfo a;
  public WTVideoInfo b;
  public int c;
  public long d;
  public float e;
  public int f;
  public boolean[] g = new boolean[3];
  public long h;
  public long i;
  
  public WTogetherPlayInfo(WTFileInfo paramWTFileInfo)
  {
    this.a = paramWTFileInfo;
    int j = paramWTFileInfo.a;
    if (j == 0)
    {
      this.b = null;
      return;
    }
    this.b = new WTVideoInfo(j, paramWTFileInfo.b, paramWTFileInfo.e, paramWTFileInfo.f, paramWTFileInfo.g, paramWTFileInfo.i, paramWTFileInfo.j, paramWTFileInfo.k, paramWTFileInfo.l, paramWTFileInfo.m);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.c != paramInt)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updatePlayState, [");
        localStringBuilder.append(this.c);
        localStringBuilder.append("-->");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], from[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.i("WTogetherPlayInfo", 2, localStringBuilder.toString());
      }
      this.c = paramInt;
    }
  }
  
  public boolean a()
  {
    WTVideoInfo localWTVideoInfo = this.b;
    return (localWTVideoInfo != null) && (localWTVideoInfo.h == 1) && (this.f <= 0);
  }
  
  public boolean a(WTVideoInfo paramWTVideoInfo)
  {
    WTVideoInfo localWTVideoInfo = this.b;
    return (localWTVideoInfo != null) && (localWTVideoInfo.a(paramWTVideoInfo));
  }
  
  public boolean b()
  {
    WTVideoInfo localWTVideoInfo = this.b;
    return (localWTVideoInfo != null) && (localWTVideoInfo.c());
  }
  
  public boolean c()
  {
    return this.a.a();
  }
  
  public float d()
  {
    return this.e;
  }
  
  public long e()
  {
    long l4 = System.currentTimeMillis();
    long l2 = this.d;
    long l3 = l2;
    if (this.c == 0)
    {
      l3 = l2;
      if (l2 != 0L)
      {
        l3 = this.h;
        long l1 = l2;
        if (l3 != 0L)
        {
          l1 = l2;
          if (l4 - l3 > 0L) {
            l1 = l2 + ((float)(l4 - l3) * this.e);
          }
        }
        l2 = this.d;
        if (l1 < l2) {
          return l2;
        }
        l2 = this.i;
        l3 = l1;
        if (l2 > 0L)
        {
          l3 = l1;
          if (l1 > l2) {
            return l2;
          }
        }
      }
    }
    return l3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayInfo{playState: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", playTimeMills: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", playRate: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", leftTime: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", lastSyncTimeMills: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", durationTimeMills: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", fileInfo: ");
    Object localObject1 = this.a;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((WTFileInfo)localObject1).toString();
    } else {
      localObject1 = null;
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(", videoInfo: ");
    WTVideoInfo localWTVideoInfo = this.b;
    localObject1 = localObject2;
    if (localWTVideoInfo != null) {
      localObject1 = localWTVideoInfo.toString();
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.data.WTogetherPlayInfo
 * JD-Core Version:    0.7.0.1
 */