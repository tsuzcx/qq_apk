package com.tencent.gdtad.api;

import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;

class GdtAd$1
  implements Runnable
{
  GdtAd$1(GdtAd paramGdtAd, WeakReference paramWeakReference, GdtAdError paramGdtAdError) {}
  
  public void run()
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (GdtAd.access$000((GdtAd)this.a.get()) != null) && (GdtAd.access$000((GdtAd)this.a.get()).get() != null))
    {
      ((GdtAdListener)GdtAd.access$000((GdtAd)this.a.get()).get()).a((GdtAd)this.a.get(), this.b);
      return;
    }
    GdtLog.d("GdtAd", "notifyFailedToLoad error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.GdtAd.1
 * JD-Core Version:    0.7.0.1
 */