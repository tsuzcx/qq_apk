package com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper;

import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView;
import pnx;

public class ProteusPagerSnapHelper$1
  implements Runnable
{
  public ProteusPagerSnapHelper$1(pnx parampnx) {}
  
  public void run()
  {
    if (!pnx.a(this.this$0)) {
      return;
    }
    this.this$0.a(this.this$0.b() + 1);
    pnx.a(this.this$0).postDelayed(this.this$0.a, pnx.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.ProteusPagerSnapHelper.1
 * JD-Core Version:    0.7.0.1
 */