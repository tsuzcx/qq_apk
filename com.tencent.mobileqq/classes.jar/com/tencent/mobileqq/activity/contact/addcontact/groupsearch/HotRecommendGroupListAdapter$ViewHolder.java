package com.tencent.mobileqq.activity.contact.addcontact.groupsearch;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class HotRecommendGroupListAdapter$ViewHolder
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  String jdField_a_of_type_JavaLangString;
  
  protected HotRecommendGroupListAdapter$ViewHolder(HotRecommendGroupListAdapter paramHotRecommendGroupListAdapter) {}
  
  public void onClick(View paramView)
  {
    if (HotRecommendGroupListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupListAdapter) != null) {
      HotRecommendGroupListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupListAdapter).a(this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.groupsearch.HotRecommendGroupListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */