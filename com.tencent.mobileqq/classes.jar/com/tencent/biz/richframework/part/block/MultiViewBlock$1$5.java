package com.tencent.biz.richframework.part.block;

class MultiViewBlock$1$5
  implements Runnable
{
  MultiViewBlock$1$5(MultiViewBlock.1 param1, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.c.a.getBlockMerger().notifyItemRangeRemoved(this.c.a.getGlobalPosition(this.a), this.b);
    this.c.a.getBlockMerger().notifyItemRangeChanged(this.c.a.getGlobalPosition(this.a), this.c.a.getBlockMerger().getItemCount() - this.c.a.getGlobalPosition(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.MultiViewBlock.1.5
 * JD-Core Version:    0.7.0.1
 */