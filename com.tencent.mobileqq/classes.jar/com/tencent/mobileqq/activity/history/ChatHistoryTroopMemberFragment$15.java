package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class ChatHistoryTroopMemberFragment$15
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$15(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    AssertUtils.checkNotNull(this.a.K);
    AssertUtils.checkNotNull(this.a.K.d);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.a.K.d.size())
    {
      localArrayList.add(((ChatHistoryTroopMemberFragment.ATroopMember)this.a.K.d.get(i)).a);
      i += 1;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("extra_member_uin_list", localArrayList);
    this.a.getBaseActivity().setResult(-1, localIntent);
    this.a.getBaseActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.15
 * JD-Core Version:    0.7.0.1
 */