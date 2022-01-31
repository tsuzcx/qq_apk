package com.tencent.gdtad.api.interstitial;

import java.lang.ref.WeakReference;
import yug;
import yui;
import yxs;

public class GdtArkPreDownloadTask$2
  implements Runnable
{
  public GdtArkPreDownloadTask$2(yug paramyug) {}
  
  public void run()
  {
    boolean bool;
    if ((yug.a(this.this$0) != null) && (yug.a(this.this$0).get() != null))
    {
      bool = true;
      yxs.b("GdtArkPreDownloadTask", String.format("notifySuccess listener:%b status:%d notified:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(yug.a(this.this$0)), Boolean.valueOf(yug.b(this.this$0)) }));
      if (!yug.b(this.this$0)) {
        break label88;
      }
    }
    label88:
    do
    {
      return;
      bool = false;
      break;
      yug.a(this.this$0, true);
    } while ((yug.a(this.this$0) == null) || (yug.a(this.this$0).get() == null));
    ((yui)yug.a(this.this$0).get()).a(yug.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.2
 * JD-Core Version:    0.7.0.1
 */