package com.tencent.gdtad.api.interstitial;

import abme;
import abmf;
import abrl;
import com.tencent.ark.open.ArkAppMgr;

public class GdtArkPreDownloadTask$5
  implements Runnable
{
  public GdtArkPreDownloadTask$5(abmf paramabmf) {}
  
  public void run()
  {
    abrl.b("GdtArkPreDownloadTask", String.format("preDownload appName:%s view:%s minVersion:%s", new Object[] { abmf.a(this.this$0).a, abmf.a(this.this$0).b, abmf.a(this.this$0).c }));
    ArkAppMgr.getInstance().getAppPathByName(abmf.a(this.this$0).a, "", abmf.a(this.this$0).c, null, abmf.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.5
 * JD-Core Version:    0.7.0.1
 */