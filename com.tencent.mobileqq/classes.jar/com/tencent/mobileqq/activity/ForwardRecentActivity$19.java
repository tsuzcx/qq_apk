package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.adapter.ForwardRecentListAdapter;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar;
import com.tencent.widget.XListView;

class ForwardRecentActivity$19
  implements Runnable
{
  ForwardRecentActivity$19(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void run()
  {
    int j = ForwardRecentActivity.access$200(this.this$0).getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = ForwardRecentActivity.access$200(this.this$0).getChildAt(i);
      if ((localView instanceof ForwardRecentItemView)) {
        ((ForwardRecentItemView)localView).a(150L);
      }
      i += 1;
    }
    this.this$0.mSelectedAndSearchBar.a(150L);
    if (ForwardRecentActivity.access$2500(this.this$0) != null) {
      ForwardRecentActivity.access$2500(this.this$0).a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.19
 * JD-Core Version:    0.7.0.1
 */