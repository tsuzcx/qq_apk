package com.tencent.mobileqq.activity.selectmember;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class SelectMemberFromFriendGroup$ListAdapter$1
  implements View.OnClickListener
{
  SelectMemberFromFriendGroup$ListAdapter$1(SelectMemberFromFriendGroup.ListAdapter paramListAdapter) {}
  
  public void onClick(View paramView)
  {
    SelectMemberFromFriendGroup.ListAdapter.ViewHolder localViewHolder = (SelectMemberFromFriendGroup.ListAdapter.ViewHolder)paramView.getTag();
    if (this.a.a.a.contains(localViewHolder.jdField_a_of_type_ComTencentMobileqqDataGroups))
    {
      this.a.a.a.remove(localViewHolder.jdField_a_of_type_ComTencentMobileqqDataGroups);
      localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.a.a.a(localViewHolder.jdField_a_of_type_ComTencentMobileqqDataGroups, false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a.a.add(localViewHolder.jdField_a_of_type_ComTencentMobileqqDataGroups);
      localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      this.a.a.a(localViewHolder.jdField_a_of_type_ComTencentMobileqqDataGroups, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberFromFriendGroup.ListAdapter.1
 * JD-Core Version:    0.7.0.1
 */