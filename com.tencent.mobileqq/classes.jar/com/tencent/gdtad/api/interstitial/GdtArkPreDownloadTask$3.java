package com.tencent.gdtad.api.interstitial;

import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;

class GdtArkPreDownloadTask$3
  implements Runnable
{
  GdtArkPreDownloadTask$3(GdtArkPreDownloadTask paramGdtArkPreDownloadTask, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    boolean bool;
    if ((GdtArkPreDownloadTask.g(this.this$0) != null) && (GdtArkPreDownloadTask.g(this.this$0).get() != null)) {
      bool = true;
    } else {
      bool = false;
    }
    GdtLog.b("GdtArkPreDownloadTask", String.format("notifyFailed listener:%b status:%d notified:%b error:%d arkError:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(GdtArkPreDownloadTask.a(this.this$0)), Boolean.valueOf(GdtArkPreDownloadTask.h(this.this$0)), Integer.valueOf(this.a), Integer.valueOf(this.b) }));
    if (GdtArkPreDownloadTask.h(this.this$0)) {
      return;
    }
    GdtArkPreDownloadTask.a(this.this$0, true);
    if ((GdtArkPreDownloadTask.g(this.this$0) != null) && (GdtArkPreDownloadTask.g(this.this$0).get() != null)) {
      ((GdtArkPreDownloadTask.Listener)GdtArkPreDownloadTask.g(this.this$0).get()).a(GdtArkPreDownloadTask.i(this.this$0), this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.3
 * JD-Core Version:    0.7.0.1
 */