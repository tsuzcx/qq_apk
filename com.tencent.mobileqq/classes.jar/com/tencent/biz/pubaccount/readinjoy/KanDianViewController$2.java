package com.tencent.biz.pubaccount.readinjoy;

import java.io.File;
import nsy;
import ntc;
import pyu;

public class KanDianViewController$2
  implements Runnable
{
  public KanDianViewController$2(nsy paramnsy) {}
  
  public void run()
  {
    String str = pyu.f();
    if ((str != null) && (new File(str).exists()))
    {
      nsy.a(this.this$0).removeMessages(2);
      nsy.a(this.this$0).sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KanDianViewController.2
 * JD-Core Version:    0.7.0.1
 */