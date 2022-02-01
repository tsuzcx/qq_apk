package com.tencent.gdtad.api.interstitial;

import aclt;
import aclu;
import acqy;
import com.tencent.ark.open.ArkAppMgr;

public class GdtArkPreDownloadTask$5
  implements Runnable
{
  public GdtArkPreDownloadTask$5(aclu paramaclu) {}
  
  public void run()
  {
    acqy.b("GdtArkPreDownloadTask", String.format("preDownload appName:%s view:%s minVersion:%s", new Object[] { aclu.a(this.this$0).a, aclu.a(this.this$0).b, aclu.a(this.this$0).c }));
    ArkAppMgr.getInstance().getAppPathByName(aclu.a(this.this$0).a, "", aclu.a(this.this$0).c, null, aclu.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.5
 * JD-Core Version:    0.7.0.1
 */