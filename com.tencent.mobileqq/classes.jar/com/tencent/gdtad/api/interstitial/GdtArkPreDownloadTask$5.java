package com.tencent.gdtad.api.interstitial;

import acbu;
import acbv;
import acho;
import com.tencent.ark.open.ArkAppMgr;

public class GdtArkPreDownloadTask$5
  implements Runnable
{
  public GdtArkPreDownloadTask$5(acbv paramacbv) {}
  
  public void run()
  {
    acho.b("GdtArkPreDownloadTask", String.format("preDownload appName:%s view:%s minVersion:%s", new Object[] { acbv.a(this.this$0).a, acbv.a(this.this$0).b, acbv.a(this.this$0).c }));
    ArkAppMgr.getInstance().getAppPathByName(acbv.a(this.this$0).a, "", acbv.a(this.this$0).c, null, acbv.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.5
 * JD-Core Version:    0.7.0.1
 */