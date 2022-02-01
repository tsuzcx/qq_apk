package com.tencent.gdtad.api.interstitial;

import acpv;
import acpw;
import acvc;
import com.tencent.ark.open.ArkAppMgr;

public class GdtArkPreDownloadTask$5
  implements Runnable
{
  public GdtArkPreDownloadTask$5(acpw paramacpw) {}
  
  public void run()
  {
    acvc.b("GdtArkPreDownloadTask", String.format("preDownload appName:%s view:%s minVersion:%s", new Object[] { acpw.a(this.this$0).a, acpw.a(this.this$0).b, acpw.a(this.this$0).c }));
    ArkAppMgr.getInstance().getAppPathByName(acpw.a(this.this$0).a, "", acpw.a(this.this$0).c, null, acpw.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.5
 * JD-Core Version:    0.7.0.1
 */