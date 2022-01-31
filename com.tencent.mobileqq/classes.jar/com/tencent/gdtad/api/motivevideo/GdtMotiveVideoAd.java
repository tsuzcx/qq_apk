package com.tencent.gdtad.api.motivevideo;

import yvi;
import yxs;
import yze;

public final class GdtMotiveVideoAd
  extends com.tencent.gdtad.api.GdtAd
{
  private yvi params;
  
  public GdtMotiveVideoAd(yvi paramyvi)
  {
    super(paramyvi);
    this.params = paramyvi;
  }
  
  public int getErrorCode(com.tencent.gdtad.aditem.GdtAd paramGdtAd, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = super.getErrorCode(paramGdtAd, paramInt1, paramInt2, paramInt3);
    if (paramInt1 != 0) {
      return paramInt1;
    }
    if ((paramGdtAd == null) || (!isValid()))
    {
      yxs.d("GdtMotiveVideoAd", "getErrorCode error");
      return 1;
    }
    if (yze.a(paramGdtAd.getCreativeSize())) {
      return 0;
    }
    return 7;
  }
  
  protected yvi getParams()
  {
    return this.params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMotiveVideoAd
 * JD-Core Version:    0.7.0.1
 */