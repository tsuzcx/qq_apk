package com.tencent.mobileqq.activity.history;

import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberHandler;
import com.tencent.widget.PinnedDividerSwipListView;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

class ChatHistoryTroopMemberFragment$4
  implements PopupMenuDialog.OnClickActionListener
{
  ChatHistoryTroopMemberFragment$4(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClickAction(PopupMenuDialog.MenuItem paramMenuItem)
  {
    if (paramMenuItem.id == this.a.bj) {
      return;
    }
    this.a.bj = paramMenuItem.id;
    ChatHistoryTroopMemberFragment.a(this.a, paramMenuItem.id);
    if ((this.a.bj >= 0) && (this.a.bj < ChatHistoryTroopMemberFragment.b(this.a).length)) {
      this.a.R.setText(ChatHistoryTroopMemberFragment.b(this.a)[this.a.bj]);
    }
    if (this.a.bj == 0)
    {
      paramMenuItem = this.a;
      paramMenuItem.a("Clk_def", paramMenuItem.aK, "");
    }
    else if (this.a.bj == 1)
    {
      ((ITroopOnlineMemberHandler)this.a.bc.getBusinessHandler(BusinessHandlerFactory.TROOP_ONLINE_MEMBER_HANDLER)).b(this.a.w);
      new ReportTask(this.a.bc).a("dc00899").b("Grp_online").c("mber_list").d("exp_onlineList").a(0).a(new String[] { this.a.w }).a();
      new ReportTask(this.a.bc).a("dc00899").b("Grp_online").c("mber_list").d("clk_onlinefirst").a(new String[] { this.a.w }).a();
    }
    else
    {
      if (this.a.bj == 2) {
        paramMenuItem = "Clk_lastactivetime";
      } else {
        paramMenuItem = "Clk_jointime";
      }
      localObject = this.a;
      ((ChatHistoryTroopMemberFragment)localObject).a(paramMenuItem, "1", ((ChatHistoryTroopMemberFragment)localObject).aK);
    }
    this.a.A();
    if (!this.a.bk) {
      this.a.bk = true;
    }
    if (this.a.K != null) {
      this.a.K.c();
    }
    if (this.a.bj == 0) {
      this.a.s.setSelectionFromTop(0, 0);
    } else {
      this.a.s.setSelectionFromTop(0, -this.a.getResources().getDimensionPixelSize(2131299611));
    }
    paramMenuItem = this.a.S;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.Q.getText().toString());
    ((StringBuilder)localObject).append(this.a.R.getText().toString());
    paramMenuItem.setContentDescription(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.4
 * JD-Core Version:    0.7.0.1
 */