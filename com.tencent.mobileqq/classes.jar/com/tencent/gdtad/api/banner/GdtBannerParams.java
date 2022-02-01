package com.tencent.gdtad.api.banner;

import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.GdtAdParams;

public final class GdtBannerParams
  extends GdtAdParams
{
  public int c = -2147483648;
  public int d = -2147483648;
  public int e = -2147483648;
  public long f = -2147483648L;
  
  public boolean a()
  {
    return (super.a()) && (this.c != -2147483648) && (this.b.b()) && (this.d > 0) && (this.e > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.GdtBannerParams
 * JD-Core Version:    0.7.0.1
 */