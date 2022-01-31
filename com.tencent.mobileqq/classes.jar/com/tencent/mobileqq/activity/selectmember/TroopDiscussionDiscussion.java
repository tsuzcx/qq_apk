package com.tencent.mobileqq.activity.selectmember;

import android.os.Bundle;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.adapter.DiscussionListAdapter2;
import com.tencent.mobileqq.adapter.DiscussionListAdapter2.DiscussionListListener;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.widget.XListView;

public class TroopDiscussionDiscussion
  extends TroopDiscussionBaseV
  implements DiscussionListAdapter2.DiscussionListListener
{
  private DiscussionListAdapter2 jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  public TroopDiscussionDiscussion(SelectMemberActivity paramSelectMemberActivity)
  {
    super(paramSelectMemberActivity);
  }
  
  public void a(Bundle paramBundle)
  {
    a(2130971522);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131366701));
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131492923);
    this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2 = new DiscussionListAdapter2(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.a(true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2);
    this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.notifyDataSetChanged();
  }
  
  public void a(DiscussionInfo paramDiscussionInfo)
  {
    Bundle localBundle;
    if (paramDiscussionInfo != null)
    {
      localBundle = new Bundle();
      localBundle.putString("group_uin", paramDiscussionInfo.uin);
      localBundle.putString("group_name", paramDiscussionInfo.discussionName);
      if ((this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a instanceof PhoneContactSelectActivity)) {
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(3, localBundle);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(7, localBundle);
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.a();
  }
  
  public void b(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopDiscussionDiscussion
 * JD-Core Version:    0.7.0.1
 */