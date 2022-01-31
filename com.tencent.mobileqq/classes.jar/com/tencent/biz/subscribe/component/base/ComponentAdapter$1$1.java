package com.tencent.biz.subscribe.component.base;

import yhy;
import yhz;
import yib;
import yyw;

public class ComponentAdapter$1$1
  implements Runnable
{
  public ComponentAdapter$1$1(yhz paramyhz) {}
  
  public void run()
  {
    if (((Integer)yyw.a().a("KEY_NOTIFY_DATA_SET_CHANGE_WAY_DEFTAUL", Integer.valueOf(1))).intValue() == 1)
    {
      this.a.a.getParentAdapter().notifyItemRangeChanged(this.a.a.getGlobalPosition(0), this.a.a.getItemCount());
      return;
    }
    this.a.a.getParentAdapter().notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.component.base.ComponentAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */