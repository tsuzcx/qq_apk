package com.tencent.gdtad.api.banner;

import com.tencent.gdtad.log.GdtLog;

public final class GdtBannerViewBuilder
{
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      double d = paramInt2;
      Double.isNaN(d);
      return Double.valueOf(d * 1.0D / 249.0D * 1026.0D).intValue();
    }
    GdtLog.d("GdtBannerViewBuilder", "getWidth error");
    return -2147483648;
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      double d = paramInt2;
      Double.isNaN(d);
      return Double.valueOf(d * 1.0D / 1026.0D * 249.0D).intValue();
    }
    GdtLog.d("GdtBannerViewBuilder", "getHeight error");
    return -2147483648;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.GdtBannerViewBuilder
 * JD-Core Version:    0.7.0.1
 */