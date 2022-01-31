package com.tencent.gdtad.api.interstitial;

import aaju;
import aajw;
import aanp;
import java.lang.ref.WeakReference;

public class GdtArkPreDownloadTask$4
  implements Runnable
{
  public GdtArkPreDownloadTask$4(aaju paramaaju, int paramInt) {}
  
  public void run()
  {
    if ((aaju.a(this.this$0) != null) && (aaju.a(this.this$0).get() != null)) {}
    for (boolean bool = true;; bool = false)
    {
      aanp.b("GdtArkPreDownloadTask", String.format("notifyStatusChanged listener:%b status:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.a) }));
      if ((aaju.a(this.this$0) != null) && (aaju.a(this.this$0).get() != null)) {
        ((aajw)aaju.a(this.this$0).get()).a(aaju.a(this.this$0), this.a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.4
 * JD-Core Version:    0.7.0.1
 */