package com.tencent.gdtad.basics.motivevideo.data;

import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;

public final class GdtMotiveVideoAd
  extends com.tencent.gdtad.api.GdtAd
{
  private GdtMotiveVideoParams params;
  
  public GdtMotiveVideoAd(GdtMotiveVideoParams paramGdtMotiveVideoParams)
  {
    super(paramGdtMotiveVideoParams);
    this.params = paramGdtMotiveVideoParams;
  }
  
  protected int getErrorCode(com.tencent.gdtad.aditem.GdtAd paramGdtAd, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = super.getErrorCode(paramGdtAd, paramInt1, paramInt2, paramInt3);
    if (paramInt1 != 0) {
      return paramInt1;
    }
    if ((paramGdtAd != null) && (isValid()) && (getParams().a != null))
    {
      if (GdtUIUtils.a(paramGdtAd.getCreativeSize())) {
        return 0;
      }
      return 7;
    }
    GdtLog.d("GdtMotiveVideoAd", "getErrorCode error");
    return 1;
  }
  
  protected GdtMotiveVideoParams getParams()
  {
    return this.params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoAd
 * JD-Core Version:    0.7.0.1
 */