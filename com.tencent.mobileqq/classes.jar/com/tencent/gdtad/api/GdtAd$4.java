package com.tencent.gdtad.api;

import aane;
import aase;
import java.lang.ref.WeakReference;

class GdtAd$4
  implements Runnable
{
  GdtAd$4(GdtAd paramGdtAd, WeakReference paramWeakReference) {}
  
  public void run()
  {
    if ((this.a == null) || (this.a.get() == null) || (GdtAd.access$000((GdtAd)this.a.get()) == null) || (GdtAd.access$000((GdtAd)this.a.get()).get() == null))
    {
      aase.d("GdtAd", "notifyClicked error");
      return;
    }
    aase.b("GdtAd", "notifyClicked");
    ((aane)GdtAd.access$000((GdtAd)this.a.get()).get()).c((GdtAd)this.a.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.GdtAd.4
 * JD-Core Version:    0.7.0.1
 */