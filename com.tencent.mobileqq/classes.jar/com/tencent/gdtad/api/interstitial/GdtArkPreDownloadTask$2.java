package com.tencent.gdtad.api.interstitial;

import aclu;
import aclw;
import acqy;
import java.lang.ref.WeakReference;

public class GdtArkPreDownloadTask$2
  implements Runnable
{
  public GdtArkPreDownloadTask$2(aclu paramaclu) {}
  
  public void run()
  {
    boolean bool;
    if ((aclu.a(this.this$0) != null) && (aclu.a(this.this$0).get() != null))
    {
      bool = true;
      acqy.b("GdtArkPreDownloadTask", String.format("notifySuccess listener:%b status:%d notified:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(aclu.a(this.this$0)), Boolean.valueOf(aclu.b(this.this$0)) }));
      if (!aclu.b(this.this$0)) {
        break label88;
      }
    }
    label88:
    do
    {
      return;
      bool = false;
      break;
      aclu.a(this.this$0, true);
    } while ((aclu.a(this.this$0) == null) || (aclu.a(this.this$0).get() == null));
    ((aclw)aclu.a(this.this$0).get()).a(aclu.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.2
 * JD-Core Version:    0.7.0.1
 */