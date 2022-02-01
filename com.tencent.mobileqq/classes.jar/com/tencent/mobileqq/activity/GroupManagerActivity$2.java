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
      if (this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity.a.size() <= paramInt) {
        return;
      }
      paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity;
      GroupManagerActivity.a(paramAdapterView, (Groups)paramAdapterView.a.get(paramInt));
      paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity;
      GroupManagerActivity.a(paramAdapterView, DialogUtils.a(paramAdapterView, 2131693089, 2131693093, GroupManagerActivity.a(paramAdapterView).group_name, this.jdField_a_of_type_ComTencentMobileqqUtilsGroupManagerInputTextWatcher, GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity), GroupManagerActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity)));
      GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GroupManagerActivity.2
 * JD-Core Version:    0.7.0.1
 */