package com.tencent.biz.pubaccount.readinjoy;

import java.io.File;
import nwc;
import nwf;
import nwg;
import qip;

public class KanDianViewController$PullRefreshCompleteListener$2
  implements Runnable
{
  public KanDianViewController$PullRefreshCompleteListener$2(nwf paramnwf) {}
  
  public void run()
  {
    String str = qip.f();
    if ((str != null) && (new File(str).exists()))
    {
      nwc.a(this.a.a, str);
      nwc.a(this.a.a).removeMessages(3);
      nwc.a(this.a.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.2
 * JD-Core Version:    0.7.0.1
 */