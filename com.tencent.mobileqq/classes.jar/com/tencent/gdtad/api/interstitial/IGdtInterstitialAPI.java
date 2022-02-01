package com.tencent.gdtad.api.interstitial;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IGdtInterstitialAPI
  extends QRouteApi
{
  public abstract IGdtInterstitialAd build(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams);
  
  public abstract void init(Context paramContext);
  
  public abstract void preDownload(Context paramContext);
  
  public abstract void preDownloadAfterToolProcessStartup(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.IGdtInterstitialAPI
 * JD-Core Version:    0.7.0.1
 */