package com.tencent.biz.pubaccount.readinjoy.automator;

import ony;
import onz;
import ooa;
import ood;
import ooe;

public class Automator$6
  implements Runnable
{
  public Automator$6(onz paramonz, ooa paramooa) {}
  
  public void run()
  {
    this.a.c();
    ood localood = this.a.a();
    if ((localood instanceof ony))
    {
      ((ony)localood).b();
      return;
    }
    if ((localood instanceof ooe))
    {
      ((ooe)localood).b();
      return;
    }
    onz.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.automator.Automator.6
 * JD-Core Version:    0.7.0.1
 */