package com.tencent.gdtad.api.interstitial;

import aaop;
import aaoq;
import aase;
import java.lang.ref.WeakReference;

public class GdtInterstitialAd$IPCHandlerForClose$1
  implements Runnable
{
  public GdtInterstitialAd$IPCHandlerForClose$1(aaop paramaaop, String paramString) {}
  
  public void run()
  {
    WeakReference localWeakReference = aaoq.a().a(this.a);
    if ((localWeakReference == null) || (localWeakReference.get() == null)) {
      return;
    }
    aase.d("GdtInterstitialAd", "IPCHandlerForClose.handle timeout");
    ((GdtInterstitialFragment)localWeakReference.get()).a(4, 13, -2147483648, -2147483648, -2147483648L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialAd.IPCHandlerForClose.1
 * JD-Core Version:    0.7.0.1
 */