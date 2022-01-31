package com.tencent.biz.pubaccount.readinjoy;

import java.io.File;
import nhr;
import nhv;
import pnc;

public class KanDianViewController$2
  implements Runnable
{
  public KanDianViewController$2(nhr paramnhr) {}
  
  public void run()
  {
    String str = pnc.e();
    if ((str != null) && (new File(str).exists()))
    {
      nhr.a(this.this$0).removeMessages(2);
      nhr.a(this.this$0).sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KanDianViewController.2
 * JD-Core Version:    0.7.0.1
 */