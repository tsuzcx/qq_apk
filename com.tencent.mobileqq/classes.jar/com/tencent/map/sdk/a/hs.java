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
    if (this.a == null) {}
    Rect localRect;
    do
    {
      return null;
      localRect = this.a.g();
    } while (localRect == null);
    int j = localRect.left;
    int i = localRect.right;
    int m = localRect.top;
    int k = localRect.bottom;
    int i3 = (localRect.right + localRect.left) / 2;
    int n = (localRect.top + localRect.bottom) / 2;
    int i4 = localRect.right;
    int i5 = localRect.left;
    int i1 = localRect.bottom;
    int i2 = localRect.top;
    if (i4 - i5 < fz.v * 40.0F)
    {
      j = (int)(i3 - fz.v * 20.0F);
      i = (int)(i3 + fz.v * 20.0F);
    }
    if (i1 - i2 < fz.v * 40.0F)
    {
      m = (int)(n - fz.v * 20.0F);
      k = (int)(n + fz.v * 20.0F);
    }
    return new Rect(j, m, i, k);
  }
  
  public final String b()
  {
    if (this.a == null) {
      return null;
    }
    return this.a.k();
  }
  
  public final void c()
  {
    if (this.b != null)
    {
      TencentMap.OnMarkerClickListener localOnMarkerClickListener = this.b.z;
      if ((this.a != null) && (localOnMarkerClickListener != null)) {
        localOnMarkerClickListener.onMarkerClick(this.a.G);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.hs
 * JD-Core Version:    0.7.0.1
 */