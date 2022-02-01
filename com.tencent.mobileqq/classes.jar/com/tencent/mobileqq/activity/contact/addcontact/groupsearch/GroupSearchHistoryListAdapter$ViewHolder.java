package com.tencent.mobileqq.activity.contact.addcontact.groupsearch;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GroupSearchHistoryListAdapter$ViewHolder
  implements View.OnClickListener
{
  public int a;
  public View a;
  public ImageView a;
  public TextView a;
  public PressEffectImageView a;
  public View b;
  
  GroupSearchHistoryListAdapter$ViewHolder(GroupSearchHistoryListAdapter paramGroupSearchHistoryListAdapter) {}
  
  public void onClick(View paramView)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchHistoryListAdapter.a(this.jdField_a_of_type_Int);
    if (paramView == this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectImageView)
    {
      GroupSearchHistoryManager.a().b(GroupSearchHistoryListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchHistoryListAdapter), str);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchHistoryListAdapter.a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView == this.jdField_a_of_type_AndroidViewView) && (GroupSearchHistoryListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchHistoryListAdapter) != null)) {
        GroupSearchHistoryListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchHistoryListAdapter).a(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchHistoryListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */