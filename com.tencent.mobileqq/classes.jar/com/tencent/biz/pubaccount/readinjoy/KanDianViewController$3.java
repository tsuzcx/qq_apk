package com.tencent.biz.pubaccount.readinjoy;

import java.io.File;
import ois;
import oiw;
import raj;

public class KanDianViewController$3
  implements Runnable
{
  public KanDianViewController$3(ois paramois) {}
  
  public void run()
  {
    String str = raj.f();
    if ((str != null) && (new File(str).exists()))
    {
      ois.a(this.this$0).removeMessages(2);
      ois.a(this.this$0).sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KanDianViewController.3
 * JD-Core Version:    0.7.0.1
 */