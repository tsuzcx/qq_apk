package com.tencent.av.wtogether.adapter;

import com.tencent.mobileqq.search.util.BaseSearchUtil;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;

class GroupFileSearchExpandableListAdapter$1
  implements Runnable
{
  GroupFileSearchExpandableListAdapter$1(GroupFileSearchExpandableListAdapter paramGroupFileSearchExpandableListAdapter, EllipsizingTextView paramEllipsizingTextView, TroopFileInfo paramTroopFileInfo, String paramString) {}
  
  public void run()
  {
    CharSequence localCharSequence = BaseSearchUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.c, this.jdField_a_of_type_JavaLangString, true);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText("");
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(localCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.adapter.GroupFileSearchExpandableListAdapter.1
 * JD-Core Version:    0.7.0.1
 */