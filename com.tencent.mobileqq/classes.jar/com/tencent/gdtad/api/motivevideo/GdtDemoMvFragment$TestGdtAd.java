package com.tencent.gdtad.api.motivevideo;

import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoParams;

public final class GdtDemoMvFragment$TestGdtAd
  extends GdtAd
{
  private GdtMotiveVideoParams params;
  
  public GdtDemoMvFragment$TestGdtAd(GdtDemoMvFragment paramGdtDemoMvFragment, GdtMotiveVideoParams paramGdtMotiveVideoParams)
  {
    super(paramGdtMotiveVideoParams);
    this.params = paramGdtMotiveVideoParams;
  }
  
  protected GdtMotiveVideoParams getParams()
  {
    return this.params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtDemoMvFragment.TestGdtAd
 * JD-Core Version:    0.7.0.1
 */