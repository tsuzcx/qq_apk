package com.tencent.gdtad.api.interstitial;

import com.tencent.ark.open.ArkAppMgr;
import com.tencent.gdtad.log.GdtLog;

class GdtArkPreDownloadTask$5
  implements Runnable
{
  GdtArkPreDownloadTask$5(GdtArkPreDownloadTask paramGdtArkPreDownloadTask) {}
  
  public void run()
  {
    GdtLog.b("GdtArkPreDownloadTask", String.format("preDownload appName:%s view:%s minVersion:%s", new Object[] { GdtArkPreDownloadTask.i(this.this$0).a, GdtArkPreDownloadTask.i(this.this$0).b, GdtArkPreDownloadTask.i(this.this$0).c }));
    ArkAppMgr.getInstance().getAppPathByName(GdtArkPreDownloadTask.i(this.this$0).a, GdtArkPreDownloadTask.i(this.this$0).c, GdtArkPreDownloadTask.j(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.5
 * JD-Core Version:    0.7.0.1
 */