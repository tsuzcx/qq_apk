package com.tencent.gdtad.api.interstitial.impl;

import android.content.Context;
import com.tencent.gdtad.api.interstitial.GdtInterstitialAd;
import com.tencent.gdtad.api.interstitial.GdtInterstitialManager;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.gdtad.api.interstitial.GdtInterstitialPreDownloader;
import com.tencent.gdtad.api.interstitial.IGdtInterstitialAPI;
import com.tencent.gdtad.api.interstitial.IGdtInterstitialAd;

public final class GdtInterstitialAPIImpl
  implements IGdtInterstitialAPI
{
  public IGdtInterstitialAd build(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams)
  {
    return new GdtInterstitialAd(paramContext, paramGdtInterstitialParams);
  }
  
  public void init(Context paramContext)
  {
    GdtInterstitialManager.a().a();
  }
  
  public void preDownload(Context paramContext)
  {
    GdtInterstitialPreDownloader.a().b(paramContext);
  }
  
  public void preDownloadAfterToolProcessStartup(Context paramContext)
  {
    GdtInterstitialPreDownloader.a().a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.impl.GdtInterstitialAPIImpl
 * JD-Core Version:    0.7.0.1
 */