package com.tencent.biz.qqcircle.bizparts.danmaku.config;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.qcircle.application.QCircleApplication;

public class PhotoDanmakuConfig
{
  public static final int a = ViewUtils.a(5.0F);
  public static final int b = ViewUtils.a(10.0F);
  public static final int c = ViewUtils.a(1.5F);
  public static final SparseArray<PhotoDanmakuConfig> y = new SparseArray();
  public static boolean z = true;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public float j;
  public int k;
  public float l;
  public float m;
  public float n;
  public float o;
  public float p;
  public float q;
  public boolean r;
  public boolean s;
  public boolean t;
  public int u;
  public int v;
  public int w;
  public int x;
  
  private PhotoDanmakuConfig(Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    paramInt1 = paramContext.widthPixels;
    int i1 = paramContext.heightPixels;
    if (QCircleApplication.APP.getResources().getConfiguration().orientation == 2)
    {
      this.v = Math.min(paramInt1, i1);
      this.u = Math.max(paramInt1, i1);
    }
    else
    {
      this.v = Math.max(paramInt1, i1);
      this.u = Math.min(paramInt1, i1);
    }
    if (paramInt2 != 1)
    {
      if (paramInt2 != 2) {
        return;
      }
      this.d = 8160;
      this.e = (ViewUtils.a(a + 24) + ImmersiveUtils.a(QCircleApplication.APP));
      this.g = ViewUtils.a(4.0F);
      this.h = ViewUtils.a(9.0F);
      this.l = ViewUtils.a(2.0F);
      this.m = ViewUtils.a(c);
      this.p = ViewUtils.a(15.0F);
      this.q = ViewUtils.a(10.0F);
      this.i = 255;
      this.j = ViewUtils.a(14.0F);
      this.k = -1;
      this.w = 10;
      this.x = 200;
      this.n = ViewUtils.a(0.0F);
      this.r = true;
      this.s = true;
      this.t = true;
      this.o = ViewUtils.a(6.0F);
      this.f = 2;
      return;
    }
    this.d = 8160;
    this.e = (ViewUtils.a(a) + ImmersiveUtils.a(QCircleApplication.APP));
    this.g = ViewUtils.a(16.0F);
    this.h = ViewUtils.a(9.0F);
    this.l = ViewUtils.a(2.0F);
    this.m = ViewUtils.a(c);
    this.p = ViewUtils.a(15.0F);
    this.q = ViewUtils.a(10.0F);
    this.i = 255;
    this.j = ViewUtils.a(14.0F);
    this.k = -1;
    this.w = 16;
    this.x = 200;
    this.n = ViewUtils.a(0.0F);
    this.r = true;
    this.s = true;
    this.t = true;
    this.o = ViewUtils.a(6.0F);
    this.f = 2;
  }
  
  public static PhotoDanmakuConfig a(Context paramContext, int paramInt1, int paramInt2)
  {
    Object localObject = y;
    int i1 = paramInt1 * 10 + paramInt2;
    localObject = (PhotoDanmakuConfig)((SparseArray)localObject).get(i1);
    if (localObject == null) {
      try
      {
        PhotoDanmakuConfig localPhotoDanmakuConfig = (PhotoDanmakuConfig)y.get(i1);
        localObject = localPhotoDanmakuConfig;
        if (localPhotoDanmakuConfig == null)
        {
          localObject = new PhotoDanmakuConfig(paramContext, paramInt1, paramInt2);
          y.put(i1, localObject);
        }
        return localObject;
      }
      finally {}
    }
    return localObject;
  }
  
  public static void a(boolean paramBoolean)
  {
    z = paramBoolean;
  }
  
  public static boolean a()
  {
    return z;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.config.PhotoDanmakuConfig
 * JD-Core Version:    0.7.0.1
 */