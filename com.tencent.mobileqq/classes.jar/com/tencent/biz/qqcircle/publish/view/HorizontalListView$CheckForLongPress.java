package com.tencent.biz.qqcircle.publish.view;

import android.view.View;
import android.widget.ListAdapter;

class HorizontalListView$CheckForLongPress
  extends HorizontalListView.WindowRunnnable
  implements Runnable
{
  private HorizontalListView$CheckForLongPress(HorizontalListView paramHorizontalListView)
  {
    super(paramHorizontalListView, null);
  }
  
  public void run()
  {
    boolean bool;
    Object localObject;
    if (this.this$0.a())
    {
      bool = ((View)this.this$0.getParent()).performLongClick();
    }
    else
    {
      int i = HorizontalListView.c(this.this$0);
      localObject = this.this$0;
      localObject = ((HorizontalListView)localObject).getChildAt(i - ((HorizontalListView)localObject).getFirstVisiblePosition());
      if (localObject != null)
      {
        i = HorizontalListView.c(this.this$0);
        long l = this.this$0.f.getItemId(HorizontalListView.c(this.this$0));
        if ((b()) && (!this.this$0.g))
        {
          bool = this.this$0.b((View)localObject, i, l);
          break label122;
        }
      }
      bool = false;
    }
    label122:
    if (bool)
    {
      localObject = this.this$0;
      ((HorizontalListView)localObject).r = -1;
      HorizontalListView.a((HorizontalListView)localObject);
      return;
    }
    this.this$0.r = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.view.HorizontalListView.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */