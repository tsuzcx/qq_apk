package com.tencent.gdtad.api.interstitial;

import java.lang.ref.WeakReference;
import yud;
import yuf;
import yxp;

public class GdtArkPreDownloadTask$2
  implements Runnable
{
  public GdtArkPreDownloadTask$2(yud paramyud) {}
  
  public void run()
  {
    boolean bool;
    if ((yud.a(this.this$0) != null) && (yud.a(this.this$0).get() != null))
    {
      bool = true;
      yxp.b("GdtArkPreDownloadTask", String.format("notifySuccess listener:%b status:%d notified:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(yud.a(this.this$0)), Boolean.valueOf(yud.b(this.this$0)) }));
      if (!yud.b(this.this$0)) {
        break label88;
      }
    }
    label88:
    do
    {
      return;
      bool = false;
      break;
      yud.a(this.this$0, true);
    } while ((yud.a(this.this$0) == null) || (yud.a(this.this$0).get() == null));
    ((yuf)yud.a(this.this$0).get()).a(yud.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.2
 * JD-Core Version:    0.7.0.1
 */