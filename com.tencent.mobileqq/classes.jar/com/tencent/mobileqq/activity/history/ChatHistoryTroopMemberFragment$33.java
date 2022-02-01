package com.tencent.mobileqq.activity.history;

import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistoryTroopMemberFragment$33
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$33(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_d_of_type_Int == 11) {
      ReportController.b(this.a.getActivity().app, "CliOper", "", "", "0X8006216", "0X8006216", 0, 0, "", "", "", "");
    }
    this.a.jdField_d_of_type_AndroidAppDialog.cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.33
 * JD-Core Version:    0.7.0.1
 */