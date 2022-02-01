package com.tencent.gdtad.api.interstitial;

import abmf;
import abmh;
import abrl;
import java.lang.ref.WeakReference;

public class GdtArkPreDownloadTask$2
  implements Runnable
{
  public GdtArkPreDownloadTask$2(abmf paramabmf) {}
  
  public void run()
  {
    boolean bool;
    if ((abmf.a(this.this$0) != null) && (abmf.a(this.this$0).get() != null))
    {
      bool = true;
      abrl.b("GdtArkPreDownloadTask", String.format("notifySuccess listener:%b status:%d notified:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(abmf.a(this.this$0)), Boolean.valueOf(abmf.b(this.this$0)) }));
      if (!abmf.b(this.this$0)) {
        break label88;
      }
    }
    label88:
    do
    {
      return;
      bool = false;
      break;
      abmf.a(this.this$0, true);
    } while ((abmf.a(this.this$0) == null) || (abmf.a(this.this$0).get() == null));
    ((abmh)abmf.a(this.this$0).get()).a(abmf.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.2
 * JD-Core Version:    0.7.0.1
 */