package com.tencent.gdtad.api.interstitial;

import java.lang.ref.WeakReference;
import yug;
import yui;
import yxs;

public class GdtArkPreDownloadTask$4
  implements Runnable
{
  public GdtArkPreDownloadTask$4(yug paramyug, int paramInt) {}
  
  public void run()
  {
    if ((yug.a(this.this$0) != null) && (yug.a(this.this$0).get() != null)) {}
    for (boolean bool = true;; bool = false)
    {
      yxs.b("GdtArkPreDownloadTask", String.format("notifyStatusChanged listener:%b status:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.a) }));
      if ((yug.a(this.this$0) != null) && (yug.a(this.this$0).get() != null)) {
        ((yui)yug.a(this.this$0).get()).a(yug.a(this.this$0), this.a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.4
 * JD-Core Version:    0.7.0.1
 */