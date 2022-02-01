package com.tencent.gdtad.api.interstitial;

import acbv;
import acbx;
import acho;
import java.lang.ref.WeakReference;

public class GdtArkPreDownloadTask$2
  implements Runnable
{
  public GdtArkPreDownloadTask$2(acbv paramacbv) {}
  
  public void run()
  {
    boolean bool;
    if ((acbv.a(this.this$0) != null) && (acbv.a(this.this$0).get() != null))
    {
      bool = true;
      acho.b("GdtArkPreDownloadTask", String.format("notifySuccess listener:%b status:%d notified:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(acbv.a(this.this$0)), Boolean.valueOf(acbv.b(this.this$0)) }));
      if (!acbv.b(this.this$0)) {
        break label88;
      }
    }
    label88:
    do
    {
      return;
      bool = false;
      break;
      acbv.a(this.this$0, true);
    } while ((acbv.a(this.this$0) == null) || (acbv.a(this.this$0).get() == null));
    ((acbx)acbv.a(this.this$0).get()).a(acbv.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.2
 * JD-Core Version:    0.7.0.1
 */