package com.tencent.gdtad.api.interstitial;

import acpw;
import acpy;
import acvc;
import java.lang.ref.WeakReference;

public class GdtArkPreDownloadTask$2
  implements Runnable
{
  public GdtArkPreDownloadTask$2(acpw paramacpw) {}
  
  public void run()
  {
    boolean bool;
    if ((acpw.a(this.this$0) != null) && (acpw.a(this.this$0).get() != null))
    {
      bool = true;
      acvc.b("GdtArkPreDownloadTask", String.format("notifySuccess listener:%b status:%d notified:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(acpw.a(this.this$0)), Boolean.valueOf(acpw.b(this.this$0)) }));
      if (!acpw.b(this.this$0)) {
        break label88;
      }
    }
    label88:
    do
    {
      return;
      bool = false;
      break;
      acpw.a(this.this$0, true);
    } while ((acpw.a(this.this$0) == null) || (acpw.a(this.this$0).get() == null));
    ((acpy)acpw.a(this.this$0).get()).a(acpw.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.2
 * JD-Core Version:    0.7.0.1
 */