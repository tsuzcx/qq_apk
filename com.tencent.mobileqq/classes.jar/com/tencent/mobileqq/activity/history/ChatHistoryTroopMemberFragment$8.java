package com.tencent.mobileqq.activity.history;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistoryTroopMemberFragment$8
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$8(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getActivity().setResult(0, this.a.getActivity().getIntent());
    this.a.getActivity().finish();
    if (this.a.az == 11) {
      ReportController.b(this.a.getBaseActivity().app, "CliOper", "", "", "0X8006215", "0X8006215", 0, 0, "1", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.8
 * JD-Core Version:    0.7.0.1
 */