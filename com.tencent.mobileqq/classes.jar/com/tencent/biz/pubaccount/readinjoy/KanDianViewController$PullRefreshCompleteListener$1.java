package com.tencent.biz.pubaccount.readinjoy;

import java.io.File;
import ofx;
import oga;
import ogb;
import rdv;

public class KanDianViewController$PullRefreshCompleteListener$1
  implements Runnable
{
  public KanDianViewController$PullRefreshCompleteListener$1(oga paramoga) {}
  
  public void run()
  {
    String str = rdv.f();
    if ((str != null) && (new File(str).exists()))
    {
      ofx.a(this.a.a, str);
      ofx.a(this.a.a).removeMessages(3);
      ofx.a(this.a.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.1
 * JD-Core Version:    0.7.0.1
 */