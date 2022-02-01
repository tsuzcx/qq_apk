package com.tencent.gdtad.api;

import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;

class GdtAd$2
  implements Runnable
{
  GdtAd$2(GdtAd paramGdtAd, WeakReference paramWeakReference) {}
  
  public void run()
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (GdtAd.access$000((GdtAd)this.a.get()) != null) && (GdtAd.access$000((GdtAd)this.a.get()).get() != null))
    {
      GdtLog.b("GdtAd", "notifyLoaded");
      ((GdtAdListener)GdtAd.access$000((GdtAd)this.a.get()).get()).a((GdtAd)this.a.get());
      return;
    }
    GdtLog.d("GdtAd", "notifyLoaded error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.GdtAd.2
 * JD-Core Version:    0.7.0.1
 */