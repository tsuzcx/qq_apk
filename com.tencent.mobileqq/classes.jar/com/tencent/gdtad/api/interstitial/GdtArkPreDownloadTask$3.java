package com.tencent.gdtad.api.interstitial;

import aaju;
import aajw;
import aanp;
import java.lang.ref.WeakReference;

public class GdtArkPreDownloadTask$3
  implements Runnable
{
  public GdtArkPreDownloadTask$3(aaju paramaaju, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    boolean bool;
    if ((aaju.a(this.this$0) != null) && (aaju.a(this.this$0).get() != null))
    {
      bool = true;
      aanp.b("GdtArkPreDownloadTask", String.format("notifyFailed listener:%b status:%d notified:%b error:%d arkError:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(aaju.a(this.this$0)), Boolean.valueOf(aaju.b(this.this$0)), Integer.valueOf(this.a), Integer.valueOf(this.b) }));
      if (!aaju.b(this.this$0)) {
        break label108;
      }
    }
    label108:
    do
    {
      return;
      bool = false;
      break;
      aaju.a(this.this$0, true);
    } while ((aaju.a(this.this$0) == null) || (aaju.a(this.this$0).get() == null));
    ((aajw)aaju.a(this.this$0).get()).a(aaju.a(this.this$0), this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.3
 * JD-Core Version:    0.7.0.1
 */