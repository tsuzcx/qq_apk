package com.tencent.gdtad.api.interstitial;

import aaoi;
import aaoj;
import aase;
import com.tencent.ark.open.ArkAppMgr;

public class GdtArkPreDownloadTask$5
  implements Runnable
{
  public GdtArkPreDownloadTask$5(aaoj paramaaoj) {}
  
  public void run()
  {
    aase.b("GdtArkPreDownloadTask", String.format("preDownload appName:%s view:%s minVersion:%s", new Object[] { aaoj.a(this.this$0).a, aaoj.a(this.this$0).b, aaoj.a(this.this$0).c }));
    ArkAppMgr.getInstance().getAppPathByName(aaoj.a(this.this$0).a, "", aaoj.a(this.this$0).c, null, aaoj.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.5
 * JD-Core Version:    0.7.0.1
 */