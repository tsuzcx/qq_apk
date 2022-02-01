package com.tencent.gdtad.api.interstitial;

import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;

class GdtInterstitialAd$IPCHandlerForClose$1
  implements Runnable
{
  GdtInterstitialAd$IPCHandlerForClose$1(GdtInterstitialAd.IPCHandlerForClose paramIPCHandlerForClose, String paramString) {}
  
  public void run()
  {
    WeakReference localWeakReference = GdtInterstitialManager.a().a(this.a);
    if ((localWeakReference == null) || (localWeakReference.get() == null)) {
      return;
    }
    GdtLog.d("GdtInterstitialAd", "IPCHandlerForClose.handle timeout");
    ((GdtInterstitialFragment)localWeakReference.get()).a(4, 13, -2147483648, -2147483648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialAd.IPCHandlerForClose.1
 * JD-Core Version:    0.7.0.1
 */