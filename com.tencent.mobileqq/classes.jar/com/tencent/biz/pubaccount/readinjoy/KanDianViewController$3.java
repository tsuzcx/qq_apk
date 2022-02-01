package com.tencent.biz.pubaccount.readinjoy;

import java.io.File;
import ofx;
import ogb;
import rcs;

public class KanDianViewController$3
  implements Runnable
{
  public KanDianViewController$3(ofx paramofx) {}
  
  public void run()
  {
    String str = rcs.f();
    if ((str != null) && (new File(str).exists()))
    {
      ofx.a(this.this$0).removeMessages(2);
      ofx.a(this.this$0).sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KanDianViewController.3
 * JD-Core Version:    0.7.0.1
 */