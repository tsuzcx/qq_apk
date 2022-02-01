package com.tencent.gdtad.api.motivevideo;

import aboq;
import abrl;
import absw;

public final class GdtMotiveVideoAd
  extends com.tencent.gdtad.api.GdtAd
{
  private aboq params;
  
  public GdtMotiveVideoAd(aboq paramaboq)
  {
    super(paramaboq);
    this.params = paramaboq;
  }
  
  public int getErrorCode(com.tencent.gdtad.aditem.GdtAd paramGdtAd, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = super.getErrorCode(paramGdtAd, paramInt1, paramInt2, paramInt3);
    if (paramInt1 != 0) {
      return paramInt1;
    }
    if ((paramGdtAd == null) || (!isValid()) || (getParams().a == null))
    {
      abrl.d("GdtMotiveVideoAd", "getErrorCode error");
      return 1;
    }
    if (absw.a(paramGdtAd.getCreativeSize())) {
      return 0;
    }
    return 7;
  }
  
  protected aboq getParams()
  {
    return this.params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMotiveVideoAd
 * JD-Core Version:    0.7.0.1
 */