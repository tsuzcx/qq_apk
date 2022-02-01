package com.tencent.gdtad.api.interstitial;

import acbv;
import acbx;
import acho;
import java.lang.ref.WeakReference;

public class GdtArkPreDownloadTask$4
  implements Runnable
{
  public GdtArkPreDownloadTask$4(acbv paramacbv, int paramInt) {}
  
  public void run()
  {
    if ((acbv.a(this.this$0) != null) && (acbv.a(this.this$0).get() != null)) {}
    for (boolean bool = true;; bool = false)
    {
      acho.b("GdtArkPreDownloadTask", String.format("notifyStatusChanged listener:%b status:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.a) }));
      if ((acbv.a(this.this$0) != null) && (acbv.a(this.this$0).get() != null)) {
        ((acbx)acbv.a(this.this$0).get()).a(acbv.a(this.this$0), this.a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.4
 * JD-Core Version:    0.7.0.1
 */