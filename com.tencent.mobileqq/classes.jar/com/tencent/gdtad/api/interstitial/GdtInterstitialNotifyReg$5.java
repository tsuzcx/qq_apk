package com.tencent.gdtad.api.interstitial;

import java.lang.ref.WeakReference;
import yuj;

public class GdtInterstitialNotifyReg$5
  implements Runnable
{
  public GdtInterstitialNotifyReg$5(yuj paramyuj, WeakReference paramWeakReference) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((GdtInterstitialFragment)this.a.get()).a(0, -2147483648, -2147483648);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.5
 * JD-Core Version:    0.7.0.1
 */