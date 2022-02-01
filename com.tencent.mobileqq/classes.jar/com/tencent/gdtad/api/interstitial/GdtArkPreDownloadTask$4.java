package com.tencent.gdtad.api.interstitial;

import acpw;
import acpy;
import acvc;
import java.lang.ref.WeakReference;

public class GdtArkPreDownloadTask$4
  implements Runnable
{
  public GdtArkPreDownloadTask$4(acpw paramacpw, int paramInt) {}
  
  public void run()
  {
    if ((acpw.a(this.this$0) != null) && (acpw.a(this.this$0).get() != null)) {}
    for (boolean bool = true;; bool = false)
    {
      acvc.b("GdtArkPreDownloadTask", String.format("notifyStatusChanged listener:%b status:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.a) }));
      if ((acpw.a(this.this$0) != null) && (acpw.a(this.this$0).get() != null)) {
        ((acpy)acpw.a(this.this$0).get()).a(acpw.a(this.this$0), this.a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.4
 * JD-Core Version:    0.7.0.1
 */