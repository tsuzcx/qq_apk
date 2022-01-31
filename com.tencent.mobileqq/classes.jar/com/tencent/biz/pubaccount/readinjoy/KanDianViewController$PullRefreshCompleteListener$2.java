package com.tencent.biz.pubaccount.readinjoy;

import java.io.File;
import ntb;
import nte;
import ntf;
import pyx;

public class KanDianViewController$PullRefreshCompleteListener$2
  implements Runnable
{
  public KanDianViewController$PullRefreshCompleteListener$2(nte paramnte) {}
  
  public void run()
  {
    String str = pyx.f();
    if ((str != null) && (new File(str).exists()))
    {
      ntb.a(this.a.a, str);
      ntb.a(this.a.a).removeMessages(3);
      ntb.a(this.a.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.2
 * JD-Core Version:    0.7.0.1
 */