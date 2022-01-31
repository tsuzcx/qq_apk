package com.tencent.gdtad.api.interstitial;

import aaoj;
import aaol;
import aase;
import java.lang.ref.WeakReference;

public class GdtArkPreDownloadTask$3
  implements Runnable
{
  public GdtArkPreDownloadTask$3(aaoj paramaaoj, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    boolean bool;
    if ((aaoj.a(this.this$0) != null) && (aaoj.a(this.this$0).get() != null))
    {
      bool = true;
      aase.b("GdtArkPreDownloadTask", String.format("notifyFailed listener:%b status:%d notified:%b error:%d arkError:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(aaoj.a(this.this$0)), Boolean.valueOf(aaoj.b(this.this$0)), Integer.valueOf(this.a), Integer.valueOf(this.b) }));
      if (!aaoj.b(this.this$0)) {
        break label108;
      }
    }
    label108:
    do
    {
      return;
      bool = false;
      break;
      aaoj.a(this.this$0, true);
    } while ((aaoj.a(this.this$0) == null) || (aaoj.a(this.this$0).get() == null));
    ((aaol)aaoj.a(this.this$0).get()).a(aaoj.a(this.this$0), this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.3
 * JD-Core Version:    0.7.0.1
 */