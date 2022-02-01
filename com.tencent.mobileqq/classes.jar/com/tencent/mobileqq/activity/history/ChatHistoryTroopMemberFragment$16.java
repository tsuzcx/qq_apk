package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class ChatHistoryTroopMemberFragment$16
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$16(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    AssertUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter);
    AssertUtils.a(this.a.jdField_a_of_type_JavaUtilList);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.a.jdField_a_of_type_JavaUtilList.size())
    {
      localArrayList.add(((ChatHistoryTroopMemberFragment.ATroopMember)this.a.jdField_a_of_type_JavaUtilList.get(i)).a);
      i += 1;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("extra_member_uin_list", localArrayList);
    this.a.getActivity().setResult(-1, localIntent);
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.16
 * JD-Core Version:    0.7.0.1
 */