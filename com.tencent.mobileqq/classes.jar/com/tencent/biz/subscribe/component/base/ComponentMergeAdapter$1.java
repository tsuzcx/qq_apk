package com.tencent.biz.subscribe.component.base;

import java.util.ArrayList;
import ydp;
import yds;

public class ComponentMergeAdapter$1
  implements Runnable
{
  public ComponentMergeAdapter$1(yds paramyds, ydp paramydp) {}
  
  public void run()
  {
    try
    {
      this.a.onDetachedFromRecyclerView(this.this$0.a().a());
      this.this$0.b(this.a);
      this.this$0.a.remove(this.a);
      yds.a(this.this$0, this.a, 2);
      this.this$0.notifyDataSetChanged();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.component.base.ComponentMergeAdapter.1
 * JD-Core Version:    0.7.0.1
 */