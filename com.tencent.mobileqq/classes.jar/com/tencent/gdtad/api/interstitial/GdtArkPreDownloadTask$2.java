package com.tencent.gdtad.api.interstitial;

import aaoj;
import aaol;
import aase;
import java.lang.ref.WeakReference;

public class GdtArkPreDownloadTask$2
  implements Runnable
{
  public GdtArkPreDownloadTask$2(aaoj paramaaoj) {}
  
  public void run()
  {
    boolean bool;
    if ((aaoj.a(this.this$0) != null) && (aaoj.a(this.this$0).get() != null))
    {
      bool = true;
      aase.b("GdtArkPreDownloadTask", String.format("notifySuccess listener:%b status:%d notified:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(aaoj.a(this.this$0)), Boolean.valueOf(aaoj.b(this.this$0)) }));
      if (!aaoj.b(this.this$0)) {
        break label88;
      }
    }
    label88:
    do
    {
      return;
      bool = false;
      break;
      aaoj.a(this.this$0, true);
    } while ((aaoj.a(this.this$0) == null) || (aaoj.a(this.this$0).get() == null));
    ((aaol)aaoj.a(this.this$0).get()).a(aaoj.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.2
 * JD-Core Version:    0.7.0.1
 */