package com.tencent.mobileqq.activity.selectmember;

import amny;
import amoc;
import android.os.Bundle;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.widget.XListView;

public class TroopDiscussionDiscussion
  extends TroopDiscussionBaseV
  implements amoc
{
  private amny jdField_a_of_type_Amny;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  public TroopDiscussionDiscussion(SelectMemberActivity paramSelectMemberActivity)
  {
    super(paramSelectMemberActivity);
  }
  
  public void a(Bundle paramBundle)
  {
    a(2131562911);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131381542));
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131167247);
    this.jdField_a_of_type_Amny = new amny(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    this.jdField_a_of_type_Amny.a(true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Amny);
    this.jdField_a_of_type_Amny.notifyDataSetChanged();
  }
  
  public void a(DiscussionInfo paramDiscussionInfo)
  {
    if (paramDiscussionInfo != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("group_uin", paramDiscussionInfo.uin);
      localBundle.putString("group_name", paramDiscussionInfo.discussionName);
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(7, localBundle);
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_Amny.a();
  }
  
  public void b(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopDiscussionDiscussion
 * JD-Core Version:    0.7.0.1
 */