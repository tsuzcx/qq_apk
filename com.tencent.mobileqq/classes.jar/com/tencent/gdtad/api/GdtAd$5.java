package com.tencent.gdtad.api;

import acos;
import acvc;
import java.lang.ref.WeakReference;

class GdtAd$5
  implements Runnable
{
  GdtAd$5(GdtAd paramGdtAd, WeakReference paramWeakReference) {}
  
  public void run()
  {
    if ((this.a == null) || (this.a.get() == null) || (GdtAd.access$000((GdtAd)this.a.get()) == null) || (GdtAd.access$000((GdtAd)this.a.get()).get() == null))
    {
      acvc.d("GdtAd", "notifyClosed error");
      return;
    }
    acvc.b("GdtAd", "notifyClosed");
    ((acos)GdtAd.access$000((GdtAd)this.a.get()).get()).onAdClosed((GdtAd)this.a.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.GdtAd.5
 * JD-Core Version:    0.7.0.1
 */