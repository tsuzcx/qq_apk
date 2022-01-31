package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import ohb;
import oyl;

public class FusionBiuButton$5
  implements Runnable
{
  public FusionBiuButton$5(oyl paramoyl) {}
  
  public void run()
  {
    if (oyl.a(this.this$0) == 2) {
      oyl.a(this.this$0, false);
    }
    while (oyl.a(this.this$0) != 1) {
      return;
    }
    ohb.a().b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.FusionBiuButton.5
 * JD-Core Version:    0.7.0.1
 */