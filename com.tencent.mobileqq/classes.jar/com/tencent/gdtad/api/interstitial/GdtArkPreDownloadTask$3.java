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
    if ((GdtArkPreDownloadTask.a(this.this$0) != null) && (GdtArkPreDownloadTask.a(this.this$0).get() != null))
    {
      bool = true;
      GdtLog.b("GdtArkPreDownloadTask", String.format("notifyFailed listener:%b status:%d notified:%b error:%d arkError:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(GdtArkPreDownloadTask.a(this.this$0)), Boolean.valueOf(GdtArkPreDownloadTask.b(this.this$0)), Integer.valueOf(this.a), Integer.valueOf(this.b) }));
      if (!GdtArkPreDownloadTask.b(this.this$0)) {
        break label108;
      }
    }
    label108:
    do
    {
      return;
      bool = false;
      break;
      GdtArkPreDownloadTask.a(this.this$0, true);
    } while ((GdtArkPreDownloadTask.a(this.this$0) == null) || (GdtArkPreDownloadTask.a(this.this$0).get() == null));
    ((GdtArkPreDownloadTask.Listener)GdtArkPreDownloadTask.a(this.this$0).get()).a(GdtArkPreDownloadTask.a(this.this$0), this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.3
 * JD-Core Version:    0.7.0.1
 */