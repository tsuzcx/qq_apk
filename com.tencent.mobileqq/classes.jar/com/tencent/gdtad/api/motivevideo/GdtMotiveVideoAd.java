package com.tencent.gdtad.api.motivevideo;

import yvf;
import yxp;
import yzb;

public final class GdtMotiveVideoAd
  extends com.tencent.gdtad.api.GdtAd
{
  private yvf params;
  
  public GdtMotiveVideoAd(yvf paramyvf)
  {
    super(paramyvf);
    this.params = paramyvf;
  }
  
  public int getErrorCode(com.tencent.gdtad.aditem.GdtAd paramGdtAd, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = super.getErrorCode(paramGdtAd, paramInt1, paramInt2, paramInt3);
    if (paramInt1 != 0) {
      return paramInt1;
    }
    if ((paramGdtAd == null) || (!isValid()))
    {
      yxp.d("GdtMotiveVideoAd", "getErrorCode error");
      return 1;
    }
    if (yzb.a(paramGdtAd.getCreativeSize())) {
      return 0;
    }
    return 7;
  }
  
  protected yvf getParams()
  {
    return this.params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMotiveVideoAd
 * JD-Core Version:    0.7.0.1
 */