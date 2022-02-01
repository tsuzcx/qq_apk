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
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity.c();
    if (paramInt == 0)
    {
      GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity).setDragEnabled(true);
      GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity, this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity.a(this.jdField_a_of_type_Byte));
      if (QLog.isColorLevel()) {
        QLog.d("GroupManagerActivity", 2, "DeleteFriendGroup :" + this.jdField_a_of_type_Byte + ", " + GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity));
      }
      if (!GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity)) {
        break label110;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity.a(2131693136);
    }
    label110:
    while (GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity) == null) {
      return;
    }
    GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GroupManagerActivity.10
 * JD-Core Version:    0.7.0.1
 */