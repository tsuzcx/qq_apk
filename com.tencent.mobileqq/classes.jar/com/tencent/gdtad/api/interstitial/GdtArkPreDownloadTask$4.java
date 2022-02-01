package com.tencent.gdtad.api.interstitial;

import aclu;
import aclw;
import acqy;
import java.lang.ref.WeakReference;

public class GdtArkPreDownloadTask$4
  implements Runnable
{
  public GdtArkPreDownloadTask$4(aclu paramaclu, int paramInt) {}
  
  public void run()
  {
    if ((aclu.a(this.this$0) != null) && (aclu.a(this.this$0).get() != null)) {}
    for (boolean bool = true;; bool = false)
    {
      acqy.b("GdtArkPreDownloadTask", String.format("notifyStatusChanged listener:%b status:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.a) }));
      if ((aclu.a(this.this$0) != null) && (aclu.a(this.this$0).get() != null)) {
        ((aclw)aclu.a(this.this$0).get()).a(aclu.a(this.this$0), this.a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.4
 * JD-Core Version:    0.7.0.1
 */