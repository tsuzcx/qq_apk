package com.tencent.gdtad.api.interstitial;

import com.tencent.ad.tangram.log.AdLog;

class GdtInterstitialPreDownloader$1
  implements Runnable
{
  GdtInterstitialPreDownloader$1(GdtInterstitialPreDownloader paramGdtInterstitialPreDownloader) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    GdtInterstitialPreDownloader.a(GdtInterstitialPreDownloader.a());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preDownloadAfterToolProcessStartup durationMillis:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    AdLog.i("GdtInterstitialPreDownloader", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialPreDownloader.1
 * JD-Core Version:    0.7.0.1
 */