package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.utils.DialogUtils;
import com.tencent.mobileqq.utils.GroupManagerInputTextWatcher;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.List;

class GroupManagerActivity$2
  implements AdapterView.OnItemClickListener
{
  GroupManagerActivity$2(GroupManagerActivity paramGroupManagerActivity, GroupManagerInputTextWatcher paramGroupManagerInputTextWatcher) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt -= 1;
    if (paramInt >= 0)
    {
      if (this.b.a.size() <= paramInt) {
        return;
      }
      paramAdapterView = this.b;
      GroupManagerActivity.a(paramAdapterView, (Groups)paramAdapterView.a.get(paramInt));
      paramAdapterView = this.b;
      GroupManagerActivity.a(paramAdapterView, DialogUtils.a(paramAdapterView, 2131890203, 2131890207, GroupManagerActivity.a(paramAdapterView).group_name, this.a, GroupManagerActivity.b(this.b), GroupManagerActivity.c(this.b)));
      GroupManagerActivity.a(this.b, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GroupManagerActivity.2
 * JD-Core Version:    0.7.0.1
 */