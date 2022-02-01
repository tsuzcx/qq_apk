package com.tencent.map.sdk.a;

import android.graphics.Rect;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener;

public final class hs
  extends hq
{
  private ms a;
  private pn b;
  
  public hs(pn parampn, ms paramms)
  {
    this.b = parampn;
    this.a = paramms;
  }
  
  public final Rect a()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return null;
    }
    localObject = ((ms)localObject).g();
    if (localObject == null) {
      return null;
    }
    int i = ((Rect)localObject).left;
    int j = ((Rect)localObject).right;
    int k = ((Rect)localObject).top;
    int m = ((Rect)localObject).bottom;
    int i3 = (((Rect)localObject).right + ((Rect)localObject).left) / 2;
    int n = (((Rect)localObject).top + ((Rect)localObject).bottom) / 2;
    int i4 = ((Rect)localObject).right;
    int i5 = ((Rect)localObject).left;
    int i1 = ((Rect)localObject).bottom;
    int i2 = ((Rect)localObject).top;
    float f;
    if (i4 - i5 < fz.v * 40.0F)
    {
      f = i3;
      i = (int)(f - fz.v * 20.0F);
      j = (int)(f + fz.v * 20.0F);
    }
    if (i1 - i2 < fz.v * 40.0F)
    {
      f = n;
      k = (int)(f - fz.v * 20.0F);
      m = (int)(f + fz.v * 20.0F);
    }
    return new Rect(i, k, j, m);
  }
  
  public final String b()
  {
    ms localms = this.a;
    if (localms == null) {
      return null;
    }
    return localms.k();
  }
  
  public final void c()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((pn)localObject).z;
      ms localms = this.a;
      if ((localms != null) && (localObject != null)) {
        ((TencentMap.OnMarkerClickListener)localObject).onMarkerClick(localms.G);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.hs
 * JD-Core Version:    0.7.0.1
 */