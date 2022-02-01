package com.tencent.biz.subscribe.part.block;

class MultiViewBlock$1$5
  implements Runnable
{
  MultiViewBlock$1$5(MultiViewBlock.1 param1, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.c.a.B().notifyItemRangeRemoved(this.c.a.f(this.a), this.b);
    this.c.a.B().notifyItemRangeChanged(this.c.a.f(this.a), this.c.a.B().getItemCount() - this.c.a.f(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.block.MultiViewBlock.1.5
 * JD-Core Version:    0.7.0.1
 */