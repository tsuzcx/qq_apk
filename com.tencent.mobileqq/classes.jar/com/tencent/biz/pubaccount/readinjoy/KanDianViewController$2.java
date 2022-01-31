package com.tencent.biz.pubaccount.readinjoy;

import java.io.File;
import ntb;
import ntf;
import pyx;

public class KanDianViewController$2
  implements Runnable
{
  public KanDianViewController$2(ntb paramntb) {}
  
  public void run()
  {
    String str = pyx.f();
    if ((str != null) && (new File(str).exists()))
    {
      ntb.a(this.this$0).removeMessages(2);
      ntb.a(this.this$0).sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KanDianViewController.2
 * JD-Core Version:    0.7.0.1
 */