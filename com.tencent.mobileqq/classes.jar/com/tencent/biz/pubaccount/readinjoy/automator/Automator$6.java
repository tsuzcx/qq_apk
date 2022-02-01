package com.tencent.biz.pubaccount.readinjoy.automator;

import oua;
import oub;
import ouc;
import ouf;
import oug;

public class Automator$6
  implements Runnable
{
  public Automator$6(oub paramoub, ouc paramouc) {}
  
  public void run()
  {
    this.a.c();
    ouf localouf = this.a.a();
    if ((localouf instanceof oua))
    {
      ((oua)localouf).b();
      return;
    }
    if ((localouf instanceof oug))
    {
      ((oug)localouf).b();
      return;
    }
    oub.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.automator.Automator.6
 * JD-Core Version:    0.7.0.1
 */