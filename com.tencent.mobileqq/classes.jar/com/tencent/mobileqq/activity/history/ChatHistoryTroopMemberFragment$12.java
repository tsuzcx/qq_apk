package com.tencent.mobileqq.activity.history;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistoryTroopMemberFragment$12
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$12(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.z();
    new ReportTask(this.a.getBaseActivity().app).a("dc00899").b("Grp_online").c("mber_list").d("clk_more").a(new String[] { this.a.w }).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.12
 * JD-Core Version:    0.7.0.1
 */