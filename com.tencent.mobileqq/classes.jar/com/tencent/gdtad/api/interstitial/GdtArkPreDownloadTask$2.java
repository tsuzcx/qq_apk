package com.tencent.gdtad.api.interstitial;

import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;

class GdtArkPreDownloadTask$2
  implements Runnable
{
  GdtArkPreDownloadTask$2(GdtArkPreDownloadTask paramGdtArkPreDownloadTask) {}
  
  public void run()
  {
    boolean bool;
    if ((GdtArkPreDownloadTask.g(this.this$0) != null) && (GdtArkPreDownloadTask.g(this.this$0).get() != null)) {
      bool = true;
    } else {
      bool = false;
    }
    GdtLog.b("GdtArkPreDownloadTask", String.format("notifySuccess listener:%b status:%d notified:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(GdtArkPreDownloadTask.a(this.this$0)), Boolean.valueOf(GdtArkPreDownloadTask.h(this.this$0)) }));
    if (GdtArkPreDownloadTask.h(this.this$0)) {
      return;
    }
    GdtArkPreDownloadTask.a(this.this$0, true);
    if ((GdtArkPreDownloadTask.g(this.this$0) != null) && (GdtArkPreDownloadTask.g(this.this$0).get() != null)) {
      ((GdtArkPreDownloadTask.Listener)GdtArkPreDownloadTask.g(this.this$0).get()).a(GdtArkPreDownloadTask.i(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.2
 * JD-Core Version:    0.7.0.1
 */