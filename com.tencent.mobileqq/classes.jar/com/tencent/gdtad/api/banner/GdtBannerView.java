package com.tencent.gdtad.api.banner;

import android.view.View;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.api.GdtAdView;

public abstract interface GdtBannerView
  extends GdtAdView
{
  public abstract AdAntiSpamForClick a();
  
  public abstract View b();
  
  public abstract void setSize(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.GdtBannerView
 * JD-Core Version:    0.7.0.1
 */