package com.tencent.av.wtogether.data;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class WTVideoInfo
{
  public final int a;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  public final String g;
  public final int h;
  public final String i;
  public final long j;
  
  public WTVideoInfo(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, String paramString7, long paramLong)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
    this.g = paramString6;
    this.h = paramInt2;
    this.i = paramString7;
    this.j = paramLong;
  }
  
  public boolean a()
  {
    int k = this.a;
    return (k == 2) || (k == 4);
  }
  
  public boolean a(WTVideoInfo paramWTVideoInfo)
  {
    boolean bool1;
    if (this == paramWTVideoInfo) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (paramWTVideoInfo != null)
      {
        if ((this.a == paramWTVideoInfo.a) && (this.j != paramWTVideoInfo.j) && (TextUtils.equals(this.c, paramWTVideoInfo.c)) && (TextUtils.equals(this.e, paramWTVideoInfo.e)) && (TextUtils.equals(this.f, paramWTVideoInfo.f)) && (TextUtils.equals(this.g, paramWTVideoInfo.g)) && (this.h == paramWTVideoInfo.h) && (TextUtils.equals(this.i, paramWTVideoInfo.i))) {
          return true;
        }
        bool2 = false;
      }
    }
    return bool2;
  }
  
  public boolean b()
  {
    int k = this.a;
    return (k == 4) || (k == 3);
  }
  
  public boolean c()
  {
    int k = this.a;
    boolean bool2 = false;
    boolean bool1;
    if ((k != 0) && (k != 1) && (k != 2))
    {
      if (k != 3)
      {
        if (k != 4) {
          return false;
        }
        bool1 = bool2;
        if (!TextUtils.isEmpty(this.e))
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.f))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(this.g))
            {
              bool1 = bool2;
              if (TextUtils.isEmpty(this.i)) {}
            }
          }
        }
      }
      else
      {
        for (;;)
        {
          return true;
          bool1 = bool2;
          if (TextUtils.isEmpty(this.e)) {
            break;
          }
          bool1 = bool2;
          if (TextUtils.isEmpty(this.f)) {
            break;
          }
          bool1 = bool2;
          if (TextUtils.isEmpty(this.g)) {
            break;
          }
        }
      }
    }
    else {
      bool1 = TextUtils.isEmpty(this.c) ^ true;
    }
    return bool1;
  }
  
  public int d()
  {
    int k = this.a;
    if ((k == 3) || (k == 4)) {
      try
      {
        k = Integer.parseInt(this.f);
        return k;
      }
      catch (Throwable localThrowable)
      {
        QLog.i("WTogether", 1, "init WTVideoInfo", localThrowable);
      }
    }
    return 0;
  }
  
  public String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("_");
    localStringBuilder.append(this.c);
    localStringBuilder.append("_");
    localStringBuilder.append(this.e);
    localStringBuilder.append("_");
    localStringBuilder.append(this.f);
    localStringBuilder.append("_");
    localStringBuilder.append(this.g);
    localStringBuilder.append("_");
    localStringBuilder.append(this.h);
    localStringBuilder.append("_");
    localStringBuilder.append(this.i);
    localStringBuilder.append("_");
    localStringBuilder.append(this.j);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoInfo{videoSrcType: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", title: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", url: ");
    Object localObject = this.c;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = Integer.valueOf(((String)localObject).length());
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(", cookie: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", vid: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", strPlatForm: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", strSDTForm: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", isPay: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", strLivePid: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", mediaFormat: ");
    localStringBuilder.append(this.j);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.data.WTVideoInfo
 * JD-Core Version:    0.7.0.1
 */