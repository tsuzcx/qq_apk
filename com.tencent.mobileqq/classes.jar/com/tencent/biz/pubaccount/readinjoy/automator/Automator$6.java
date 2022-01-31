package com.tencent.biz.pubaccount.readinjoy.automator;

import ohj;
import ohk;
import ohl;
import oho;
import ohp;

public class Automator$6
  implements Runnable
{
  public Automator$6(ohk paramohk, ohl paramohl) {}
  
  public void run()
  {
    this.a.c();
    oho localoho = this.a.a();
    if ((localoho instanceof ohj))
    {
      ((ohj)localoho).b();
      return;
    }
    if ((localoho instanceof ohp))
    {
      ((ohp)localoho).b();
      return;
    }
    ohk.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.automator.Automator.6
 * JD-Core Version:    0.7.0.1
 */