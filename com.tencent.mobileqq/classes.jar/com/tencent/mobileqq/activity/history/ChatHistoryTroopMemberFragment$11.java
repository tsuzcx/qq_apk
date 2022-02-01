package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class ChatHistoryTroopMemberFragment$11
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$11(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.d == 15) && (ChatHistoryTroopMemberFragment.a(this.a).size() > 0))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("param_deleted_uins", ChatHistoryTroopMemberFragment.a(this.a));
      this.a.getActivity().setResult(-1, localIntent);
      if ((this.a.f == null) || (!this.a.f.equals(this.a.getActivity().app.getCurrentAccountUin()))) {
        break label178;
      }
    }
    label178:
    for (int i = 0;; i = 1)
    {
      ReportController.b(this.a.getActivity().app, "dc00899", "Grp_mber", "", "mber_list", "del_inacmem", 0, 0, this.a.c, "" + i, "1", ChatHistoryTroopMemberFragment.a(this.a).toString());
      this.a.getActivity().finish();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.11
 * JD-Core Version:    0.7.0.1
 */