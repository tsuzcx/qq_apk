package com.tencent.gdtad.api.interstitial;

import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;

class GdtInterstitialNotifyReg$7
  implements Runnable
{
  GdtInterstitialNotifyReg$7(GdtInterstitialNotifyReg paramGdtInterstitialNotifyReg, String paramString) {}
  
  public void run()
  {
    String str = GdtInterstitialNotifyReg.a(this.a);
    WeakReference localWeakReference = GdtInterstitialNotifyReg.a(this.a);
    if ((!TextUtils.isEmpty(str)) && (localWeakReference != null) && (localWeakReference.get() != null))
    {
      int i;
      if ("ark_interstitial_video_onprogress".equals(str)) {
        i = 1;
      } else if ("ark_interstitial_video_onload".equals(str)) {
        i = 2;
      } else if ("ark_interstitial_video_onplaying".equals(str)) {
        i = 3;
      } else if ("ark_interstitial_video_onpause".equals(str)) {
        i = 4;
      } else if ("ark_interstitial_video_onended".equals(str)) {
        i = 5;
      } else if ("ark_interstitial_video_onerror".equals(str)) {
        i = 6;
      } else {
        i = -2147483648;
      }
      if (i != -2147483648) {
        ((GdtInterstitialFragment)localWeakReference.get()).a(i);
      }
      if ("ark_interstitial_onexposure".equals(str)) {
        ((GdtInterstitialFragment)localWeakReference.get()).b();
      }
      return;
    }
    GdtLog.d("GdtInterstitialNotifyReg", "receiveReport");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.7
 * JD-Core Version:    0.7.0.1
 */