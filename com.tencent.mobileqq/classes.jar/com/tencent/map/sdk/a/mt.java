package com.tencent.map.sdk.a;

import com.tencent.tencentmap.mapsdk.maps.model.MaskLayerOptions;

public final class mt
{
  public boolean a = false;
  private pn b;
  private MaskLayerOptions c;
  private int d = 0;
  private mt.a e;
  
  public mt(pn parampn, MaskLayerOptions paramMaskLayerOptions)
  {
    this.b = parampn;
    this.c = paramMaskLayerOptions;
  }
  
  private static int a(int paramInt)
  {
    return paramInt >> 16 & 0xFF;
  }
  
  private static int b(int paramInt)
  {
    return paramInt >> 8 & 0xFF;
  }
  
  private static int c(int paramInt)
  {
    return paramInt >> 24 & 0xFF;
  }
  
  public final void a(long paramLong)
  {
    if (paramLong > 0L)
    {
      locala = this.e;
      if (locala != null)
      {
        locala.b(paramLong);
        return;
      }
    }
    mt.a locala = this.e;
    if (locala != null) {
      locala.a();
    }
    c();
    b();
  }
  
  public final boolean a()
  {
    MaskLayerOptions localMaskLayerOptions = this.c;
    if (localMaskLayerOptions == null) {
      return false;
    }
    int i = localMaskLayerOptions.getColor();
    if (this.e == null) {
      this.e = new mt.a(this, a(i), b(i), i & 0xFF, c(i));
    }
    this.e.a(this.c.getAnimationDuration());
    return true;
  }
  
  public final void b()
  {
    this.e = null;
    this.b = null;
    this.c = null;
  }
  
  public final void c()
  {
    pn localpn = this.b;
    if (localpn != null)
    {
      localpn.az.d(this.d);
      this.b.az.b.k();
      this.d = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.mt
 * JD-Core Version:    0.7.0.1
 */