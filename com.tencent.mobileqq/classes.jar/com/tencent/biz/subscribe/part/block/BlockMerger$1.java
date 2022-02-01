package com.tencent.biz.subscribe.part.block;

import java.util.ArrayList;

class BlockMerger$1
  implements Runnable
{
  public void run()
  {
    try
    {
      this.a.onDetachedFromRecyclerView(this.this$0.f().getRecyclerView());
      this.this$0.b(this.a);
      BlockMerger.a(this.this$0).remove(this.a);
      BlockMerger.a(this.this$0, this.a, 2);
      this.this$0.notifyDataSetChanged();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.block.BlockMerger.1
 * JD-Core Version:    0.7.0.1
 */