package com.tencent.gdtad.api.interstitial;

import aaoj;
import aaol;
import aase;
import java.lang.ref.WeakReference;

public class GdtArkPreDownloadTask$4
  implements Runnable
{
  public GdtArkPreDownloadTask$4(aaoj paramaaoj, int paramInt) {}
  
  public void run()
  {
    if ((aaoj.a(this.this$0) != null) && (aaoj.a(this.this$0).get() != null)) {}
    for (boolean bool = true;; bool = false)
    {
      aase.b("GdtArkPreDownloadTask", String.format("notifyStatusChanged listener:%b status:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.a) }));
      if ((aaoj.a(this.this$0) != null) && (aaoj.a(this.this$0).get() != null)) {
        ((aaol)aaoj.a(this.this$0).get()).a(aaoj.a(this.this$0), this.a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.4
 * JD-Core Version:    0.7.0.1
 */