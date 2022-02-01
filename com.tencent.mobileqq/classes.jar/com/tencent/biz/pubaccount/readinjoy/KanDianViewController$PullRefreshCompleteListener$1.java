package com.tencent.biz.pubaccount.readinjoy;

import java.io.File;
import ois;
import oiv;
import oiw;
import rbm;

public class KanDianViewController$PullRefreshCompleteListener$1
  implements Runnable
{
  public KanDianViewController$PullRefreshCompleteListener$1(oiv paramoiv) {}
  
  public void run()
  {
    String str = rbm.f();
    if ((str != null) && (new File(str).exists()))
    {
      ois.a(this.a.a, str);
      ois.a(this.a.a).removeMessages(3);
      ois.a(this.a.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.1
 * JD-Core Version:    0.7.0.1
 */