package com.tencent.biz.pubaccount.readinjoy;

import java.io.File;
import ohf;
import ohi;
import ohj;
import quo;

public class KanDianViewController$PullRefreshCompleteListener$1
  implements Runnable
{
  public KanDianViewController$PullRefreshCompleteListener$1(ohi paramohi) {}
  
  public void run()
  {
    String str = quo.f();
    if ((str != null) && (new File(str).exists()))
    {
      ohf.a(this.a.a, str);
      ohf.a(this.a.a).removeMessages(3);
      ohf.a(this.a.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.1
 * JD-Core Version:    0.7.0.1
 */