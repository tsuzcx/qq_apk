package com.tencent.gdtad.api.interstitial;

import com.tencent.ad.tangram.ipc.AdIPCManager.Handler;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import com.tencent.gdtad.log.GdtLog;

final class GdtInterstitialPreDownloader$IPCHandlerForPreDownload
  implements AdIPCManager.Handler
{
  public AdIPCManager.Result handle(AdIPCManager.Params paramParams)
  {
    AdIPCManager.Result localResult = new AdIPCManager.Result();
    if ((paramParams != null) && (paramParams.isValid()))
    {
      GdtInterstitialPreDownloader.a(GdtInterstitialPreDownloader.a());
      localResult.success = true;
    }
    String str2 = null;
    String str1;
    if (paramParams != null) {
      str1 = paramParams.getAction();
    } else {
      str1 = null;
    }
    if (paramParams != null) {
      str2 = paramParams.getToProcessName();
    }
    GdtLog.b("GdtInterstitialPreDownloader", String.format("IPCHandlerForPreDownload.handle action:%s to:%s success:%b", new Object[] { str1, str2, Boolean.valueOf(localResult.success) }));
    return localResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialPreDownloader.IPCHandlerForPreDownload
 * JD-Core Version:    0.7.0.1
 */