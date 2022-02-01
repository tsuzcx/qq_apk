package com.tencent.gdtad.api.interstitial;

import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;

final class GdtInterstitialView$2
  implements Runnable
{
  GdtInterstitialView$2(String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a))
    {
      WeakReference localWeakReference = GdtInterstitialManager.a().a(this.a);
      if ((localWeakReference != null) && (localWeakReference.get() != null))
      {
        ((GdtInterstitialFragment)localWeakReference.get()).a(4, this.b, this.c, -2147483648);
        bool = true;
        break label67;
      }
    }
    boolean bool = false;
    label67:
    GdtLog.b("GdtInterstitialView", String.format("close %b error:%d traceId:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.b), this.a }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialView.2
 * JD-Core Version:    0.7.0.1
 */