package com.tencent.biz.qqstory.utils;

import android.os.SystemClock;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.image.URLDrawable.URLDrawableListener;
import java.net.URL;

class UIUtils$DrawableListenerHolder
  implements URLDrawable.DownloadListener, URLDrawable.URLDrawableListener
{
  public static int l = 1;
  public static int m = 2;
  public static int n = 4;
  public static int o = 8;
  public static int p = 16;
  public static String q = "story_url_drawable";
  URLDrawable a;
  UIUtils.URLDrawableMonitor b;
  String c;
  long d = 0L;
  long e = 0L;
  int f = 0;
  int g = 0;
  int h = 0;
  int i = 0;
  int j = 0;
  String k = "";
  
  public UIUtils$DrawableListenerHolder(UIUtils.URLDrawableMonitor paramURLDrawableMonitor, URLDrawable paramURLDrawable, String paramString)
  {
    this.a = paramURLDrawable;
    this.b = paramURLDrawableMonitor;
    this.c = paramURLDrawable.getURL().toString();
    this.e = SystemClock.uptimeMillis();
    this.k = paramString;
  }
  
  void a()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.e;
    StoryReportor.b(q, this.k, 0, this.g, new String[] { String.valueOf(this.d), String.valueOf(l1 - l2), String.valueOf(this.f), this.c });
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.g |= m;
    this.f = paramInt;
    SLog.a("Q.qqstory.UIViewUtils", "onFileDownloadFailed() %s, error(%d), %s, %d", this.c, Integer.valueOf(paramInt), this.a, Integer.valueOf(System.identityHashCode(this)));
  }
  
  public void onFileDownloadStarted()
  {
    this.e = SystemClock.uptimeMillis();
    SLog.a("Q.qqstory.UIViewUtils", "onFileDownloadStarted() %s, %s, %d", this.c, this.a, Integer.valueOf(System.identityHashCode(this)));
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    this.g |= l;
    this.d = paramLong;
    SLog.a("Q.qqstory.UIViewUtils", "onFileDownloadSucceed() %s, %d, %s, %d", this.c, Long.valueOf(paramLong), this.a, Integer.valueOf(System.identityHashCode(this)));
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.g |= p;
    SLog.a("Q.qqstory.UIViewUtils", "onLoadCanceled() %s, %s, %d", this.c, this.a, Integer.valueOf(System.identityHashCode(this)));
    a();
    this.j += 1;
    this.b.a(this);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.g |= o;
    SLog.a("Q.qqstory.UIViewUtils", "onLoadFialed() %s, %s, %d", this.c, this.a, Integer.valueOf(System.identityHashCode(this)));
    a();
    this.h += 1;
    this.b.a(this);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    SLog.a("Q.qqstory.UIViewUtils", "onLoadProgressed(%d/10000%%) %s, %s, %d", Integer.valueOf(paramInt), this.c, this.a, Integer.valueOf(System.identityHashCode(this)));
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.g |= n;
    SLog.a("Q.qqstory.UIViewUtils", "onLoadSuccessed() %s, %s, %d", this.c, this.a, Integer.valueOf(System.identityHashCode(this)));
    a();
    this.i += 1;
    this.b.a(this);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DrawableListenerHolder{url='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileSize=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", startTime=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", errorCode=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", result=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", loadFailTime=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", loadSuccessTime=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", loadCancelTime=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", op_name='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.UIUtils.DrawableListenerHolder
 * JD-Core Version:    0.7.0.1
 */