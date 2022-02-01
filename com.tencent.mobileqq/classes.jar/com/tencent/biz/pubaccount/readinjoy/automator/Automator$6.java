package com.tencent.biz.pubaccount.readinjoy.automator;

import ovv;
import ovw;
import ovx;
import owa;
import owb;

public class Automator$6
  implements Runnable
{
  public Automator$6(ovw paramovw, ovx paramovx) {}
  
  public void run()
  {
    this.a.c();
    owa localowa = this.a.a();
    if ((localowa instanceof ovv))
    {
      ((ovv)localowa).b();
      return;
    }
    if ((localowa instanceof owb))
    {
      ((owb)localowa).b();
      return;
    }
    ovw.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.automator.Automator.6
 * JD-Core Version:    0.7.0.1
 */