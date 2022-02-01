package com.tencent.biz.subscribe.part.block;

import com.tencent.biz.videostory.config.VSConfigManager;

class MultiViewBlock$1$1
  implements Runnable
{
  MultiViewBlock$1$1(MultiViewBlock.1 param1) {}
  
  public void run()
  {
    if (((Integer)VSConfigManager.a().a("KEY_NOTIFY_DATA_SET_CHANGE_WAY_DEFTAUL", Integer.valueOf(1))).intValue() == 1)
    {
      this.a.a.a().notifyItemRangeChanged(this.a.a.c(0), this.a.a.getItemCount());
      return;
    }
    this.a.a.a().notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.block.MultiViewBlock.1.1
 * JD-Core Version:    0.7.0.1
 */