package com.tencent.biz.qqcircle.publish.view;

import android.view.View;
import android.view.ViewConfiguration;

final class HorizontalListView$CheckForTap
  implements Runnable
{
  HorizontalListView$CheckForTap(HorizontalListView paramHorizontalListView) {}
  
  public void run()
  {
    if (this.this$0.r == 0)
    {
      Object localObject = this.this$0;
      ((HorizontalListView)localObject).r = 1;
      if (((HorizontalListView)localObject).a())
      {
        localObject = (View)this.this$0.getParent();
      }
      else
      {
        localObject = this.this$0;
        localObject = ((HorizontalListView)localObject).getChildAt(HorizontalListView.c((HorizontalListView)localObject) - this.this$0.getFirstVisiblePosition());
      }
      if ((this.this$0.a()) || ((localObject != null) && (!((View)localObject).hasFocusable())))
      {
        if ((this.this$0.g) && (!this.this$0.a()))
        {
          this.this$0.r = 2;
          return;
        }
        HorizontalListView.a(this.this$0, (View)localObject);
        int i = ViewConfiguration.getLongPressTimeout();
        boolean bool;
        if (this.this$0.a()) {
          bool = ((View)localObject).isLongClickable();
        } else {
          bool = this.this$0.isLongClickable();
        }
        if (bool)
        {
          if (HorizontalListView.d(this.this$0) == null)
          {
            localObject = this.this$0;
            HorizontalListView.a((HorizontalListView)localObject, new HorizontalListView.CheckForLongPress((HorizontalListView)localObject, null));
          }
          HorizontalListView.d(this.this$0).a();
          localObject = this.this$0;
          ((HorizontalListView)localObject).postDelayed(HorizontalListView.d((HorizontalListView)localObject), i);
          return;
        }
        this.this$0.r = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.view.HorizontalListView.CheckForTap
 * JD-Core Version:    0.7.0.1
 */