package com.tencent.gdtad.api.banner;

import android.content.Context;
import com.tencent.gdtad.api.IGdtAd;

public abstract interface IGdtBannerAd
  extends IGdtAd
{
  public abstract void onDisplay();
  
  public abstract GdtBannerView render(Context paramContext, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.IGdtBannerAd
 * JD-Core Version:    0.7.0.1
 */