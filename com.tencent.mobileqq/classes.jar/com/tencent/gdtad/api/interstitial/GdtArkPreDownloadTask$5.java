package com.tencent.gdtad.api.interstitial;

import com.tencent.ark.open.ArkAppMgr;
import yuf;
import yug;
import yxs;

public class GdtArkPreDownloadTask$5
  implements Runnable
{
  public GdtArkPreDownloadTask$5(yug paramyug) {}
  
  public void run()
  {
    yxs.b("GdtArkPreDownloadTask", String.format("preDownload appName:%s view:%s minVersion:%s", new Object[] { yug.a(this.this$0).a, yug.a(this.this$0).b, yug.a(this.this$0).c }));
    ArkAppMgr.getInstance().getAppPathByName(yug.a(this.this$0).a, "", yug.a(this.this$0).c, null, yug.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.5
 * JD-Core Version:    0.7.0.1
 */