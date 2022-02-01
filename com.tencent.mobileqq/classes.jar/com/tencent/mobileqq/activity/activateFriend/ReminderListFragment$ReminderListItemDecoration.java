package com.tencent.mobileqq.activity.activateFriend;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

class ReminderListFragment$ReminderListItemDecoration
  extends RecyclerView.ItemDecoration
{
  private ReminderListFragment$ReminderListItemDecoration(ReminderListFragment paramReminderListFragment) {}
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    paramRect.left = AIOUtils.b(16.0F, this.a.getResources());
    paramRect.right = AIOUtils.b(16.0F, this.a.getResources());
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    int j = ReminderListFragment.g(this.a).getItemCount();
    if (QLog.isColorLevel())
    {
      paramView = ReminderListFragment.a();
      paramRecyclerView = new StringBuilder();
      paramRecyclerView.append("position: ");
      paramRecyclerView.append(i);
      paramRecyclerView.append(", totalCnt: ");
      paramRecyclerView.append(j);
      QLog.i(paramView, 2, paramRecyclerView.toString());
    }
    paramRect.top = AIOUtils.b(12.0F, this.a.getResources());
    if (i == j - 1) {
      paramRect.bottom = AIOUtils.b(12.0F, this.a.getResources());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.ReminderListItemDecoration
 * JD-Core Version:    0.7.0.1
 */