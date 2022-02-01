package com.tencent.mobileqq.activity.history;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistoryBaseTenDocFragment$4
  implements View.OnClickListener
{
  ChatHistoryBaseTenDocFragment$4(ChatHistoryBaseTenDocFragment paramChatHistoryBaseTenDocFragment) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.a, "dc00898", "", "", "0X800A16A", "0X800A16A", ChatHistoryBaseTenDocFragment.a(this.a), 0, "", "", "s_qq_history_tab", "");
    TeamWorkUtils.a(this.a.getActivity(), "s_qq_history_tab", 1121);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseTenDocFragment.4
 * JD-Core Version:    0.7.0.1
 */