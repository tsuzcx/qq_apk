package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.memberlist.TroopMemberListConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class ChatHistoryTroopMemberFragment$22
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$22(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.c.getBaseActivity(), TroopMemberListConstants.class);
    ((Intent)localObject).putExtra("troop_uin", this.c.w);
    ((Intent)localObject).putExtra("param_from", 15);
    ((Intent)localObject).putExtra("param_seq_days", ChatHistoryTroopMemberFragment.i(this.c));
    ((Intent)localObject).putExtra("param_seq_name", ChatHistoryTroopMemberFragment.j(this.c));
    ((Intent)localObject).putExtra("TROOP_INFO_MEMBER_NUM", this.a);
    this.c.startActivityForResult((Intent)localObject, 4);
    localObject = this.c.getBaseActivity().app;
    String str = this.c.w;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.b);
    ReportController.b((AppRuntime)localObject, "dc00899", "Grp_mber", "", "mber_list", "clk_inacentry", 0, 0, str, localStringBuilder.toString(), "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.22
 * JD-Core Version:    0.7.0.1
 */