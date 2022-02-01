package com.tencent.biz.pubaccount.readinjoy.automator;

import omn;
import omo;
import omp;
import oms;
import omt;

public class Automator$6
  implements Runnable
{
  public Automator$6(omo paramomo, omp paramomp) {}
  
  public void run()
  {
    this.a.c();
    oms localoms = this.a.a();
    if ((localoms instanceof omn))
    {
      ((omn)localoms).b();
      return;
    }
    if ((localoms instanceof omt))
    {
      ((omt)localoms).b();
      return;
    }
    omo.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.automator.Automator.6
 * JD-Core Version:    0.7.0.1
 */