package com.tencent.gdtad.api.interstitial;

import com.tencent.ad.tangram.ipc.AdIPCManager.Callback;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import com.tencent.gdtad.log.GdtLog;

class GdtInterstitialAd$1
  implements AdIPCManager.Callback
{
  GdtInterstitialAd$1(GdtInterstitialAd paramGdtInterstitialAd) {}
  
  public void onCallback(AdIPCManager.Params paramParams, AdIPCManager.Result paramResult)
  {
    if (paramResult != null) {}
    for (boolean bool = paramResult.success;; bool = false)
    {
      GdtLog.b("GdtInterstitialAd", String.format("close.onCallback %b", new Object[] { Boolean.valueOf(bool) }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialAd.1
 * JD-Core Version:    0.7.0.1
 */