package com.tencent.gdtad.api.interstitial;

import java.lang.ref.WeakReference;
import yug;
import yui;
import yxs;

public class GdtArkPreDownloadTask$3
  implements Runnable
{
  public GdtArkPreDownloadTask$3(yug paramyug, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    boolean bool;
    if ((yug.a(this.this$0) != null) && (yug.a(this.this$0).get() != null))
    {
      bool = true;
      yxs.b("GdtArkPreDownloadTask", String.format("notifyFailed listener:%b status:%d notified:%b error:%d arkError:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(yug.a(this.this$0)), Boolean.valueOf(yug.b(this.this$0)), Integer.valueOf(this.a), Integer.valueOf(this.b) }));
      if (!yug.b(this.this$0)) {
        break label108;
      }
    }
    label108:
    do
    {
      return;
      bool = false;
      break;
      yug.a(this.this$0, true);
    } while ((yug.a(this.this$0) == null) || (yug.a(this.this$0).get() == null));
    ((yui)yug.a(this.this$0).get()).a(yug.a(this.this$0), this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.3
 * JD-Core Version:    0.7.0.1
 */