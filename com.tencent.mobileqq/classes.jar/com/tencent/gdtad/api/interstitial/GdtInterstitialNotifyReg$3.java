package com.tencent.gdtad.api.interstitial;

import aakc;
import java.lang.ref.WeakReference;

public class GdtInterstitialNotifyReg$3
  implements Runnable
{
  public GdtInterstitialNotifyReg$3(aakc paramaakc, WeakReference paramWeakReference) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((GdtInterstitialFragment)this.a.get()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.3
 * JD-Core Version:    0.7.0.1
 */