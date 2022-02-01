package com.tencent.biz.richframework.part.block;

import aabj;
import aabp;
import aabq;
import abac;

public class MultiViewBlock$1$1
  implements Runnable
{
  public MultiViewBlock$1$1(aabq paramaabq) {}
  
  public void run()
  {
    if (((Integer)abac.a().a("KEY_NOTIFY_DATA_SET_CHANGE_WAY_DEFTAUL", Integer.valueOf(1))).intValue() == 1)
    {
      this.a.a.getBlockMerger().notifyItemRangeChanged(this.a.a.getGlobalPosition(0), this.a.a.getItemCount());
      return;
    }
    this.a.a.getBlockMerger().notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.MultiViewBlock.1.1
 * JD-Core Version:    0.7.0.1
 */