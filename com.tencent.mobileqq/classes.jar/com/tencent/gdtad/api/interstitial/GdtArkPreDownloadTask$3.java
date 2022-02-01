package com.tencent.gdtad.api.interstitial;

import abmf;
import abmh;
import abrl;
import java.lang.ref.WeakReference;

public class GdtArkPreDownloadTask$3
  implements Runnable
{
  public GdtArkPreDownloadTask$3(abmf paramabmf, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    boolean bool;
    if ((abmf.a(this.this$0) != null) && (abmf.a(this.this$0).get() != null))
    {
      bool = true;
      abrl.b("GdtArkPreDownloadTask", String.format("notifyFailed listener:%b status:%d notified:%b error:%d arkError:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(abmf.a(this.this$0)), Boolean.valueOf(abmf.b(this.this$0)), Integer.valueOf(this.a), Integer.valueOf(this.b) }));
      if (!abmf.b(this.this$0)) {
        break label108;
      }
    }
    label108:
    do
    {
      return;
      bool = false;
      break;
      abmf.a(this.this$0, true);
    } while ((abmf.a(this.this$0) == null) || (abmf.a(this.this$0).get() == null));
    ((abmh)abmf.a(this.this$0).get()).a(abmf.a(this.this$0), this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.3
 * JD-Core Version:    0.7.0.1
 */