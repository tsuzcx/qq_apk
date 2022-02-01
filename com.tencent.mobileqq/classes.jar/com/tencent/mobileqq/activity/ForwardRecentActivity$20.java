package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.adapter.ForwardRecentListAdapter;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar;
import com.tencent.widget.XListView;

class ForwardRecentActivity$20
  implements Runnable
{
  ForwardRecentActivity$20(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void run()
  {
    int j = ForwardRecentActivity.access$200(this.this$0).getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = ForwardRecentActivity.access$200(this.this$0).getChildAt(i);
      if ((localView instanceof ForwardRecentItemView)) {
        ((ForwardRecentItemView)localView).b(150L);
      }
      i += 1;
    }
    this.this$0.mSelectedAndSearchBar.b(150L);
    if (ForwardRecentActivity.access$2500(this.this$0) != null) {
      ForwardRecentActivity.access$2500(this.this$0).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.20
 * JD-Core Version:    0.7.0.1
 */