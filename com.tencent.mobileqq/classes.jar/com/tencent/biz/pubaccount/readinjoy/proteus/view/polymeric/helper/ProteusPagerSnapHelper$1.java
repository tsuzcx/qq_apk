package com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper;

import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView;

class ProteusPagerSnapHelper$1
  implements Runnable
{
  ProteusPagerSnapHelper$1(ProteusPagerSnapHelper paramProteusPagerSnapHelper) {}
  
  public void run()
  {
    if (!ProteusPagerSnapHelper.a(this.this$0)) {
      return;
    }
    this.this$0.a(this.this$0.b() + 1);
    ProteusPagerSnapHelper.a(this.this$0).postDelayed(this.this$0.a, ProteusPagerSnapHelper.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.ProteusPagerSnapHelper.1
 * JD-Core Version:    0.7.0.1
 */