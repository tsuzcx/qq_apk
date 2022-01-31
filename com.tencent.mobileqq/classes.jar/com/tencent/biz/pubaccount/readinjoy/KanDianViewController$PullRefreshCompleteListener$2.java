package com.tencent.biz.pubaccount.readinjoy;

import java.io.File;
import nsy;
import ntb;
import ntc;
import pyu;

public class KanDianViewController$PullRefreshCompleteListener$2
  implements Runnable
{
  public KanDianViewController$PullRefreshCompleteListener$2(ntb paramntb) {}
  
  public void run()
  {
    String str = pyu.f();
    if ((str != null) && (new File(str).exists()))
    {
      nsy.a(this.a.a, str);
      nsy.a(this.a.a).removeMessages(3);
      nsy.a(this.a.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.2
 * JD-Core Version:    0.7.0.1
 */