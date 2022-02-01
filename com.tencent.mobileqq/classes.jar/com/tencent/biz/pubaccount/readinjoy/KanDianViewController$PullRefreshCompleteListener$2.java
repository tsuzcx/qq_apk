package com.tencent.biz.pubaccount.readinjoy;

import java.io.File;
import oqo;
import oqr;
import oqs;
import rmp;

public class KanDianViewController$PullRefreshCompleteListener$2
  implements Runnable
{
  public KanDianViewController$PullRefreshCompleteListener$2(oqr paramoqr) {}
  
  public void run()
  {
    String str = rmp.f();
    if ((str != null) && (new File(str).exists()))
    {
      oqo.a(this.a.a, str);
      oqo.a(this.a.a).removeMessages(3);
      oqo.a(this.a.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.2
 * JD-Core Version:    0.7.0.1
 */