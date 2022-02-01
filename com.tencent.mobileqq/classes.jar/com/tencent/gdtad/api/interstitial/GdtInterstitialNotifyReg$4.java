package com.tencent.gdtad.api.interstitial;

import java.lang.ref.WeakReference;

class GdtInterstitialNotifyReg$4
  implements Runnable
{
  GdtInterstitialNotifyReg$4(GdtInterstitialNotifyReg paramGdtInterstitialNotifyReg, WeakReference paramWeakReference, int paramInt) {}
  
  public void run()
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((GdtInterstitialFragment)this.a.get()).a(this.b, 0, -2147483648, -2147483648);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.4
 * JD-Core Version:    0.7.0.1
 */