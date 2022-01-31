package com.tencent.gdtad.api.motivevideo;

import ylr;
import yny;
import ypk;

public final class GdtMotiveVideoAd
  extends com.tencent.gdtad.api.GdtAd
{
  private ylr params;
  
  public GdtMotiveVideoAd(ylr paramylr)
  {
    super(paramylr);
    this.params = paramylr;
  }
  
  public int getErrorCode(com.tencent.gdtad.aditem.GdtAd paramGdtAd, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = super.getErrorCode(paramGdtAd, paramInt1, paramInt2, paramInt3);
    if (paramInt1 != 0) {
      return paramInt1;
    }
    if ((paramGdtAd == null) || (!isValid()))
    {
      yny.d("GdtMotiveVideoAd", "getErrorCode error");
      return 1;
    }
    if (ypk.a(paramGdtAd.getCreativeSize())) {
      return 0;
    }
    return 7;
  }
  
  protected ylr getParams()
  {
    return this.params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMotiveVideoAd
 * JD-Core Version:    0.7.0.1
 */