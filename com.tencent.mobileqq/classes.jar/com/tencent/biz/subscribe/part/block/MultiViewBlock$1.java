package com.tencent.biz.subscribe.part.block;

import android.os.Handler;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;

class MultiViewBlock$1
  extends RecyclerView.AdapterDataObserver
{
  MultiViewBlock$1(MultiViewBlock paramMultiViewBlock) {}
  
  public void onChanged()
  {
    MultiViewBlock.a(this.a).post(new MultiViewBlock.1.1(this));
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    MultiViewBlock.a(this.a).post(new MultiViewBlock.1.2(this, paramInt1, paramInt2));
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    MultiViewBlock.a(this.a).post(new MultiViewBlock.1.3(this, paramInt1, paramInt2, paramObject));
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    MultiViewBlock.a(this.a).post(new MultiViewBlock.1.4(this, paramInt1, paramInt2));
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    MultiViewBlock.a(this.a).post(new MultiViewBlock.1.6(this, paramInt1, paramInt2));
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    MultiViewBlock.a(this.a).post(new MultiViewBlock.1.5(this, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.block.MultiViewBlock.1
 * JD-Core Version:    0.7.0.1
 */