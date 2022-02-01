package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class ChatHistoryTroopMemberFragment$15
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$15(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    AssertUtils.a(this.a.a);
    AssertUtils.a(this.a.a.a);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.a.a.a.size())
    {
      localArrayList.add(((ChatHistoryTroopMemberFragment.ATroopMember)this.a.a.a.get(i)).a);
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
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.15
 * JD-Core Version:    0.7.0.1
 */