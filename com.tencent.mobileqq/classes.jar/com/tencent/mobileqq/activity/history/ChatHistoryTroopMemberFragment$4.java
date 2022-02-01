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
    if (paramMenuItem.id == this.a.m) {
      return;
    }
    this.a.m = paramMenuItem.id;
    ChatHistoryTroopMemberFragment.a(this.a, paramMenuItem.id);
    if ((this.a.m >= 0) && (this.a.m < ChatHistoryTroopMemberFragment.a(this.a).length)) {
      this.a.jdField_c_of_type_AndroidWidgetTextView.setText(ChatHistoryTroopMemberFragment.a(this.a)[this.a.m]);
    }
    if (this.a.m == 0)
    {
      paramMenuItem = this.a;
      paramMenuItem.a("Clk_def", paramMenuItem.o, "");
    }
    else if (this.a.m == 1)
    {
      ((ITroopOnlineMemberHandler)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_ONLINE_MEMBER_HANDLER)).b(this.a.jdField_c_of_type_JavaLangString);
      new ReportTask(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("mber_list").d("exp_onlineList").a(0).a(new String[] { this.a.jdField_c_of_type_JavaLangString }).a();
      new ReportTask(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("mber_list").d("clk_onlinefirst").a(new String[] { this.a.jdField_c_of_type_JavaLangString }).a();
    }
    else
    {
      if (this.a.m == 2) {
        paramMenuItem = "Clk_lastactivetime";
      } else {
        paramMenuItem = "Clk_jointime";
      }
      localObject = this.a;
      ((ChatHistoryTroopMemberFragment)localObject).a(paramMenuItem, "1", ((ChatHistoryTroopMemberFragment)localObject).o);
    }
    this.a.w();
    if (!this.a.p) {
      this.a.p = true;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.a();
    }
    if (this.a.m == 0) {
      this.a.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelectionFromTop(0, 0);
    } else {
      this.a.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelectionFromTop(0, -this.a.getResources().getDimensionPixelSize(2131298889));
    }
    paramMenuItem = this.a.jdField_a_of_type_AndroidWidgetLinearLayout;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
    ((StringBuilder)localObject).append(this.a.jdField_c_of_type_AndroidWidgetTextView.getText().toString());
    paramMenuItem.setContentDescription(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.4
 * JD-Core Version:    0.7.0.1
 */