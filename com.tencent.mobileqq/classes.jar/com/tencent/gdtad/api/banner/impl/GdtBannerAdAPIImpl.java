package com.tencent.gdtad.api.banner.impl;

import com.tencent.gdtad.api.banner.GdtBannerAd;
import com.tencent.gdtad.api.banner.GdtBannerParams;
import com.tencent.gdtad.api.banner.IGdtBannerAd;
import com.tencent.gdtad.api.banner.IGdtBannerAdAPI;

public class GdtBannerAdAPIImpl
  implements IGdtBannerAdAPI
{
  public IGdtBannerAd buildBannerAd(GdtBannerParams paramGdtBannerParams)
  {
    return new GdtBannerAd(paramGdtBannerParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.impl.GdtBannerAdAPIImpl
 * JD-Core Version:    0.7.0.1
 */