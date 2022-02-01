package com.tencent.biz.richframework.part.block;

import java.util.ArrayList;
import yzj;
import yzp;

public class BlockMerger$1
  implements Runnable
{
  public void run()
  {
    try
    {
      this.a.onDetachedFromRecyclerView(this.this$0.a().a());
      this.this$0.b(this.a);
      yzj.a(this.this$0).remove(this.a);
      yzj.a(this.this$0, this.a, 2);
      this.this$0.notifyDataSetChanged();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.BlockMerger.1
 * JD-Core Version:    0.7.0.1
 */