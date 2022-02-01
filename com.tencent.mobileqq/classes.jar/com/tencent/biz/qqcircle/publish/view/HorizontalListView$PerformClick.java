package com.tencent.biz.qqcircle.publish.view;

import android.view.View;
import android.widget.ListAdapter;

class HorizontalListView$PerformClick
  extends HorizontalListView.WindowRunnnable
  implements Runnable
{
  int a;
  
  private HorizontalListView$PerformClick(HorizontalListView paramHorizontalListView)
  {
    super(paramHorizontalListView, null);
  }
  
  public void run()
  {
    if (this.this$0.a())
    {
      ((View)this.this$0.getParent()).performClick();
      return;
    }
    if (this.this$0.g) {
      return;
    }
    ListAdapter localListAdapter = this.this$0.f;
    int i = this.a;
    if ((localListAdapter != null) && (i != -1) && (i < localListAdapter.getCount()) && (b()))
    {
      Object localObject = this.this$0;
      localObject = ((HorizontalListView)localObject).getChildAt(i - ((HorizontalListView)localObject).getFirstVisiblePosition());
      if (localObject != null) {
        this.this$0.performItemClick((View)localObject, i, localListAdapter.getItemId(i));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.view.HorizontalListView.PerformClick
 * JD-Core Version:    0.7.0.1
 */