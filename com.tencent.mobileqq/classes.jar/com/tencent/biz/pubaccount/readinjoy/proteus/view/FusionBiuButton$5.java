package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import osm;
import pkd;

public class FusionBiuButton$5
  implements Runnable
{
  public FusionBiuButton$5(pkd parampkd) {}
  
  public void run()
  {
    if (pkd.a(this.this$0) == 2) {
      pkd.a(this.this$0, false);
    }
    while (pkd.a(this.this$0) != 1) {
      return;
    }
    osm.a().b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.FusionBiuButton.5
 * JD-Core Version:    0.7.0.1
 */