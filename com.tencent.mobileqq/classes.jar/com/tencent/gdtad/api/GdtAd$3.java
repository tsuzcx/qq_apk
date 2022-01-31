package com.tencent.gdtad.api;

import java.lang.ref.WeakReference;
import ytb;
import yxs;

class GdtAd$3
  implements Runnable
{
  GdtAd$3(GdtAd paramGdtAd, WeakReference paramWeakReference) {}
  
  public void run()
  {
    if ((this.a == null) || (this.a.get() == null) || (GdtAd.access$000((GdtAd)this.a.get()) == null) || (GdtAd.access$000((GdtAd)this.a.get()).get() == null))
    {
      yxs.d("GdtAd", "notifyImpression error");
      return;
    }
    yxs.b("GdtAd", "notifyImpression");
    ((ytb)GdtAd.access$000((GdtAd)this.a.get()).get()).b((GdtAd)this.a.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.GdtAd.3
 * JD-Core Version:    0.7.0.1
 */