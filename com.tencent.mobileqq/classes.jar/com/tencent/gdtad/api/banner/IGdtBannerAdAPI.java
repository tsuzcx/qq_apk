package com.tencent.gdtad.api.banner;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IGdtBannerAdAPI
  extends QRouteApi
{
  public abstract IGdtBannerAd buildBannerAd(GdtBannerParams paramGdtBannerParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.IGdtBannerAdAPI
 * JD-Core Version:    0.7.0.1
 */