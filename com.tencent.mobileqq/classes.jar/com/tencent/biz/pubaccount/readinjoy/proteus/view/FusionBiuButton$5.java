package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import osj;
import pka;

public class FusionBiuButton$5
  implements Runnable
{
  public FusionBiuButton$5(pka parampka) {}
  
  public void run()
  {
    if (pka.a(this.this$0) == 2) {
      pka.a(this.this$0, false);
    }
    while (pka.a(this.this$0) != 1) {
      return;
    }
    osj.a().b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.FusionBiuButton.5
 * JD-Core Version:    0.7.0.1
 */