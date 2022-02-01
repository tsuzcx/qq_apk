package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.adapter.GroupEditeDragSortAdapter;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class GroupManagerActivity$10
  implements ActionSheet.OnButtonClickListener
{
  GroupManagerActivity$10(GroupManagerActivity paramGroupManagerActivity, byte paramByte) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.b.c();
    if (paramInt == 0)
    {
      GroupManagerActivity.h(this.b).setDragEnabled(true);
      paramView = this.b;
      GroupManagerActivity.a(paramView, paramView.a(this.a));
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("DeleteFriendGroup :");
        paramView.append(this.a);
        paramView.append(", ");
        paramView.append(GroupManagerActivity.f(this.b));
        QLog.d("GroupManagerActivity", 2, paramView.toString());
      }
      if (GroupManagerActivity.f(this.b))
      {
        this.b.a(2131890210);
        return;
      }
      if (GroupManagerActivity.g(this.b) != null) {
        GroupManagerActivity.g(this.b).notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GroupManagerActivity.10
 * JD-Core Version:    0.7.0.1
 */