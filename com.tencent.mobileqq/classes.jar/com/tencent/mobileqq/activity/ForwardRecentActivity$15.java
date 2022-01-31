package com.tencent.mobileqq.activity;

import aimy;
import android.view.View;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.widget.XListView;

class ForwardRecentActivity$15
  implements Runnable
{
  ForwardRecentActivity$15(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void run()
  {
    int j = ForwardRecentActivity.a(this.this$0).getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = ForwardRecentActivity.a(this.this$0).getChildAt(i);
      if ((localView instanceof ForwardRecentItemView)) {
        ((ForwardRecentItemView)localView).a(150L);
      }
      i += 1;
    }
    this.this$0.a.a(150L);
    if (ForwardRecentActivity.a(this.this$0) != null) {
      ForwardRecentActivity.a(this.this$0).a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.15
 * JD-Core Version:    0.7.0.1
 */