package com.tencent.biz.pubaccount.readinjoy;

import java.io.File;
import nwc;
import nwf;
import nwg;
import qjs;

public class KanDianViewController$PullRefreshCompleteListener$1
  implements Runnable
{
  public KanDianViewController$PullRefreshCompleteListener$1(nwf paramnwf) {}
  
  public void run()
  {
    String str = qjs.f();
    if ((str != null) && (new File(str).exists()))
    {
      nwc.a(this.a.a, str);
      nwc.a(this.a.a).removeMessages(3);
      nwc.a(this.a.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.1
 * JD-Core Version:    0.7.0.1
 */