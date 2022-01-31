package com.tencent.biz.pubaccount.readinjoy;

import java.io.File;
import nhr;
import nhu;
import nhv;
import pnc;

public class KanDianViewController$PullRefreshCompleteListener$2
  implements Runnable
{
  public KanDianViewController$PullRefreshCompleteListener$2(nhu paramnhu) {}
  
  public void run()
  {
    String str = pnc.e();
    if ((str != null) && (new File(str).exists()))
    {
      nhr.a(this.a.a, str);
      nhr.a(this.a.a).removeMessages(3);
      nhr.a(this.a.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.2
 * JD-Core Version:    0.7.0.1
 */