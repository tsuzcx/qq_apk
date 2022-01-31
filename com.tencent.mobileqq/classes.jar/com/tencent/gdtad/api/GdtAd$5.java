package com.tencent.gdtad.api;

import java.lang.ref.WeakReference;
import ysy;
import yxp;

class GdtAd$5
  implements Runnable
{
  GdtAd$5(GdtAd paramGdtAd, WeakReference paramWeakReference) {}
  
  public void run()
  {
    if ((this.a == null) || (this.a.get() == null) || (GdtAd.access$000((GdtAd)this.a.get()) == null) || (GdtAd.access$000((GdtAd)this.a.get()).get() == null))
    {
      yxp.d("GdtAd", "notifyClosed error");
      return;
    }
    yxp.b("GdtAd", "notifyClosed");
    ((ysy)GdtAd.access$000((GdtAd)this.a.get()).get()).d((GdtAd)this.a.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.GdtAd.5
 * JD-Core Version:    0.7.0.1
 */