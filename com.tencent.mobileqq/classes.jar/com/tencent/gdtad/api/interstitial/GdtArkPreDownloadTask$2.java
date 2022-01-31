package com.tencent.gdtad.api.interstitial;

import aaju;
import aajw;
import aanp;
import java.lang.ref.WeakReference;

public class GdtArkPreDownloadTask$2
  implements Runnable
{
  public GdtArkPreDownloadTask$2(aaju paramaaju) {}
  
  public void run()
  {
    boolean bool;
    if ((aaju.a(this.this$0) != null) && (aaju.a(this.this$0).get() != null))
    {
      bool = true;
      aanp.b("GdtArkPreDownloadTask", String.format("notifySuccess listener:%b status:%d notified:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(aaju.a(this.this$0)), Boolean.valueOf(aaju.b(this.this$0)) }));
      if (!aaju.b(this.this$0)) {
        break label88;
      }
    }
    label88:
    do
    {
      return;
      bool = false;
      break;
      aaju.a(this.this$0, true);
    } while ((aaju.a(this.this$0) == null) || (aaju.a(this.this$0).get() == null));
    ((aajw)aaju.a(this.this$0).get()).a(aaju.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.2
 * JD-Core Version:    0.7.0.1
 */