package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistoryTroopMemberFragment$17
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$17(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a.getBaseActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", "https://m.vip.qq.com/freedom/freedom_group_all.html?_wv=1");
    this.a.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.17
 * JD-Core Version:    0.7.0.1
 */