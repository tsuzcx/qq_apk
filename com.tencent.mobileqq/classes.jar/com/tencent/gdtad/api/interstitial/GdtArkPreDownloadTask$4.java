package com.tencent.gdtad.api.interstitial;

import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;

class GdtArkPreDownloadTask$4
  implements Runnable
{
  GdtArkPreDownloadTask$4(GdtArkPreDownloadTask paramGdtArkPreDownloadTask, int paramInt) {}
  
  public void run()
  {
    boolean bool;
    if ((GdtArkPreDownloadTask.a(this.this$0) != null) && (GdtArkPreDownloadTask.a(this.this$0).get() != null)) {
      bool = true;
    } else {
      bool = false;
    }
    GdtLog.b("GdtArkPreDownloadTask", String.format("notifyStatusChanged listener:%b status:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.a) }));
    if ((GdtArkPreDownloadTask.a(this.this$0) != null) && (GdtArkPreDownloadTask.a(this.this$0).get() != null)) {
      ((GdtArkPreDownloadTask.Listener)GdtArkPreDownloadTask.a(this.this$0).get()).a(GdtArkPreDownloadTask.a(this.this$0), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.4
 * JD-Core Version:    0.7.0.1
 */