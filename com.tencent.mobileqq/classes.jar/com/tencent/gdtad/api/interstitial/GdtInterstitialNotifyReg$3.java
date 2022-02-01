package com.tencent.gdtad.api.interstitial;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

class GdtInterstitialNotifyReg$3
  implements Runnable
{
  GdtInterstitialNotifyReg$3(GdtInterstitialNotifyReg paramGdtInterstitialNotifyReg, WeakReference paramWeakReference, JSONObject paramJSONObject) {}
  
  public void run()
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (this.b != null) && (!JSONObject.NULL.equals(this.b)) && (((GdtInterstitialFragment)this.a.get()).d() != null) && (((GdtInterstitialFragment)this.a.get()).d().d != null)) {
      ((GdtInterstitialFragment)this.a.get()).d().d.n = this.b.toString();
    }
    localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((GdtInterstitialFragment)this.a.get()).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.3
 * JD-Core Version:    0.7.0.1
 */