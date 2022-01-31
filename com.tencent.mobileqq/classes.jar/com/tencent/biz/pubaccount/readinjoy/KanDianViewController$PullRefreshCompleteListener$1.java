package com.tencent.biz.pubaccount.readinjoy;

import java.io.File;
import nsy;
import ntb;
import ntc;
import pzx;

public class KanDianViewController$PullRefreshCompleteListener$1
  implements Runnable
{
  public KanDianViewController$PullRefreshCompleteListener$1(ntb paramntb) {}
  
  public void run()
  {
    String str = pzx.f();
    if ((str != null) && (new File(str).exists()))
    {
      nsy.a(this.a.a, str);
      nsy.a(this.a.a).removeMessages(3);
      nsy.a(this.a.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.1
 * JD-Core Version:    0.7.0.1
 */