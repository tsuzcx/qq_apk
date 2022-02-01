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
    if ((paramInt - 1 < 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity.a.size() <= paramInt - 1)) {
      return;
    }
    GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity, (Groups)this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity.a.get(paramInt - 1));
    GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity, DialogUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity, 2131693129, 2131693133, GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity).group_name, this.jdField_a_of_type_ComTencentMobileqqUtilsGroupManagerInputTextWatcher, GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity), GroupManagerActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity)));
    GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GroupManagerActivity.2
 * JD-Core Version:    0.7.0.1
 */