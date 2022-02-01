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
    if ((TextUtils.isEmpty(str)) || (localWeakReference == null) || (localWeakReference.get() == null))
    {
      GdtLog.d("GdtInterstitialNotifyReg", "receiveReport");
      return;
    }
    int i;
    if ("ark_interstitial_video_onprogress".equals(str)) {
      i = 1;
    }
    for (;;)
    {
      if (i != -2147483648) {
        ((GdtInterstitialFragment)localWeakReference.get()).a(i);
      }
      if (!"ark_interstitial_onexposure".equals(str)) {
        break;
      }
      ((GdtInterstitialFragment)localWeakReference.get()).b();
      return;
      if ("ark_interstitial_video_onload".equals(str)) {
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.7
 * JD-Core Version:    0.7.0.1
 */