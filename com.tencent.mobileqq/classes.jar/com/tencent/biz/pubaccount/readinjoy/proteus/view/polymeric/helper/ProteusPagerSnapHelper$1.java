package com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper;

import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView;
import puf;

public class ProteusPagerSnapHelper$1
  implements Runnable
{
  public ProteusPagerSnapHelper$1(puf parampuf) {}
  
  public void run()
  {
    if (!puf.a(this.this$0)) {
      return;
    }
    this.this$0.a(this.this$0.b() + 1);
    puf.a(this.this$0).postDelayed(this.this$0.a, puf.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.ProteusPagerSnapHelper.1
 * JD-Core Version:    0.7.0.1
 */