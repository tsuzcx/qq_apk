package com.tencent.biz.richframework.part.block;

import com.tencent.biz.videostory.config.VSConfigManager;
import yzj;
import yzp;
import yzq;

public class MultiViewBlock$1$1
  implements Runnable
{
  public MultiViewBlock$1$1(yzq paramyzq) {}
  
  public void run()
  {
    if (((Integer)VSConfigManager.getInstance().getValue("KEY_NOTIFY_DATA_SET_CHANGE_WAY_DEFTAUL", Integer.valueOf(1))).intValue() == 1)
    {
      this.a.a.a().notifyItemRangeChanged(this.a.a.b(0), this.a.a.getItemCount());
      return;
    }
    this.a.a.a().notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.MultiViewBlock.1.1
 * JD-Core Version:    0.7.0.1
 */