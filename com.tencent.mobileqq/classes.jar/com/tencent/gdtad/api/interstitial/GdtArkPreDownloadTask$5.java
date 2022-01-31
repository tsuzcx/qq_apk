package com.tencent.gdtad.api.interstitial;

import aajt;
import aaju;
import aanp;
import com.tencent.ark.open.ArkAppMgr;

public class GdtArkPreDownloadTask$5
  implements Runnable
{
  public GdtArkPreDownloadTask$5(aaju paramaaju) {}
  
  public void run()
  {
    aanp.b("GdtArkPreDownloadTask", String.format("preDownload appName:%s view:%s minVersion:%s", new Object[] { aaju.a(this.this$0).a, aaju.a(this.this$0).b, aaju.a(this.this$0).c }));
    ArkAppMgr.getInstance().getAppPathByName(aaju.a(this.this$0).a, "", aaju.a(this.this$0).c, null, aaju.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.5
 * JD-Core Version:    0.7.0.1
 */