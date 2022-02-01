package com.tencent.gdtad.api.interstitial;

import com.tencent.ad.tangram.ipc.AdIPCManager.Callback;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import com.tencent.gdtad.log.GdtLog;

class GdtInterstitialPreDownloader$2
  implements AdIPCManager.Callback
{
  GdtInterstitialPreDownloader$2(GdtInterstitialPreDownloader paramGdtInterstitialPreDownloader) {}
  
  public void onCallback(AdIPCManager.Params paramParams, AdIPCManager.Result paramResult)
  {
    boolean bool;
    if (paramResult != null) {
      bool = paramResult.success;
    } else {
      bool = false;
    }
    GdtLog.b("GdtInterstitialPreDownloader", String.format("predownload.onCallback %b", new Object[] { Boolean.valueOf(bool) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialPreDownloader.2
 * JD-Core Version:    0.7.0.1
 */