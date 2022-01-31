package com.tencent.gdtad.api.interstitial;

import java.lang.ref.WeakReference;
import yum;

public class GdtInterstitialNotifyReg$4
  implements Runnable
{
  public GdtInterstitialNotifyReg$4(yum paramyum, WeakReference paramWeakReference) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((GdtInterstitialFragment)this.a.get()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.4
 * JD-Core Version:    0.7.0.1
 */