package com.tencent.biz.subscribe.component.base;

import wpc;
import wpd;
import wpf;
import xfr;

public class ComponentAdapter$1$1
  implements Runnable
{
  public ComponentAdapter$1$1(wpd paramwpd) {}
  
  public void run()
  {
    if (((Integer)xfr.a().a("KEY_NOTIFY_DATA_SET_CHANGE_WAY_DEFTAUL", Integer.valueOf(1))).intValue() == 1)
    {
      this.a.a.a().notifyItemRangeChanged(this.a.a.c(0), this.a.a.getItemCount());
      return;
    }
    this.a.a.a().notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.component.base.ComponentAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */