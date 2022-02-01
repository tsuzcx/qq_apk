package com.tencent.gdtad.api.interstitial;

import acma;
import acmb;
import acqy;
import java.lang.ref.WeakReference;

public class GdtInterstitialAd$IPCHandlerForClose$1
  implements Runnable
{
  public GdtInterstitialAd$IPCHandlerForClose$1(acma paramacma, String paramString) {}
  
  public void run()
  {
    WeakReference localWeakReference = acmb.a().a(this.a);
    if ((localWeakReference == null) || (localWeakReference.get() == null)) {
      return;
    }
    acqy.d("GdtInterstitialAd", "IPCHandlerForClose.handle timeout");
    ((GdtInterstitialFragment)localWeakReference.get()).a(4, 13, -2147483648, -2147483648, -2147483648L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialAd.IPCHandlerForClose.1
 * JD-Core Version:    0.7.0.1
 */