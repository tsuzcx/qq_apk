package com.tencent.gdtad.api;

import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;

class GdtAd$4
  implements Runnable
{
  GdtAd$4(GdtAd paramGdtAd, WeakReference paramWeakReference) {}
  
  public void run()
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (GdtAd.access$000((GdtAd)this.a.get()) != null) && (GdtAd.access$000((GdtAd)this.a.get()).get() != null))
    {
      GdtLog.b("GdtAd", "notifyClicked");
      ((GdtAdListener)GdtAd.access$000((GdtAd)this.a.get()).get()).c((GdtAd)this.a.get());
      return;
    }
    GdtLog.d("GdtAd", "notifyClicked error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.GdtAd.4
 * JD-Core Version:    0.7.0.1
 */