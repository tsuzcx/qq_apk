package com.tencent.gdtad.api.interstitial;

import acqc;
import acqd;
import acvc;
import java.lang.ref.WeakReference;

public class GdtInterstitialAd$IPCHandlerForClose$1
  implements Runnable
{
  public GdtInterstitialAd$IPCHandlerForClose$1(acqc paramacqc, String paramString) {}
  
  public void run()
  {
    WeakReference localWeakReference = acqd.a().a(this.a);
    if ((localWeakReference == null) || (localWeakReference.get() == null)) {
      return;
    }
    acvc.d("GdtInterstitialAd", "IPCHandlerForClose.handle timeout");
    ((GdtInterstitialFragment)localWeakReference.get()).a(4, 13, -2147483648, -2147483648, -2147483648L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialAd.IPCHandlerForClose.1
 * JD-Core Version:    0.7.0.1
 */