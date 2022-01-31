package com.tencent.gdtad.api.interstitial;

import com.tencent.ark.open.ArkAppMgr;
import yuc;
import yud;
import yxp;

public class GdtArkPreDownloadTask$5
  implements Runnable
{
  public GdtArkPreDownloadTask$5(yud paramyud) {}
  
  public void run()
  {
    yxp.b("GdtArkPreDownloadTask", String.format("preDownload appName:%s view:%s minVersion:%s", new Object[] { yud.a(this.this$0).a, yud.a(this.this$0).b, yud.a(this.this$0).c }));
    ArkAppMgr.getInstance().getAppPathByName(yud.a(this.this$0).a, "", yud.a(this.this$0).c, null, yud.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.5
 * JD-Core Version:    0.7.0.1
 */