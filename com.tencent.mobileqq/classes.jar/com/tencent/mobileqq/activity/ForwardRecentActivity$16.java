package com.tencent.mobileqq.activity;

import amhc;
import android.view.View;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.widget.XListView;

class ForwardRecentActivity$16
  implements Runnable
{
  ForwardRecentActivity$16(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void run()
  {
    int j = ForwardRecentActivity.a(this.this$0).getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = ForwardRecentActivity.a(this.this$0).getChildAt(i);
      if ((localView instanceof ForwardRecentItemView)) {
        ((ForwardRecentItemView)localView).b(150L);
      }
      i += 1;
    }
    this.this$0.a.b(150L);
    if (ForwardRecentActivity.a(this.this$0) != null) {
      ForwardRecentActivity.a(this.this$0).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.16
 * JD-Core Version:    0.7.0.1
 */