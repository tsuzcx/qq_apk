package com.tencent.mobileqq.activity.history;

import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.widget.PinnedDividerSwipListView;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

class ChatHistoryTroopMemberFragment$4
  implements PopupMenuDialog.OnClickActionListener
{
  ChatHistoryTroopMemberFragment$4(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    if (paramMenuItem.a == this.a.m) {
      return;
    }
    this.a.m = paramMenuItem.a;
    ChatHistoryTroopMemberFragment.a(this.a, paramMenuItem.a);
    if ((this.a.m >= 0) && (this.a.m < ChatHistoryTroopMemberFragment.a(this.a).length)) {
      this.a.jdField_c_of_type_AndroidWidgetTextView.setText(ChatHistoryTroopMemberFragment.a(this.a)[this.a.m]);
    }
    if (this.a.m == 0)
    {
      this.a.a("Clk_def", this.a.o, "");
      this.a.w();
      if (!this.a.p) {
        this.a.p = true;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.a();
      }
      if (this.a.m != 0) {
        break label434;
      }
      this.a.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelectionFromTop(0, 0);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription(this.a.jdField_b_of_type_AndroidWidgetTextView.getText().toString() + this.a.jdField_c_of_type_AndroidWidgetTextView.getText().toString());
      return;
      if (this.a.m == 1)
      {
        ((TroopHandler)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).t(this.a.jdField_c_of_type_JavaLangString);
        new ReportTask(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("mber_list").d("exp_onlineList").a(0).a(new String[] { this.a.jdField_c_of_type_JavaLangString }).a();
        new ReportTask(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("mber_list").d("clk_onlinefirst").a(new String[] { this.a.jdField_c_of_type_JavaLangString }).a();
        break;
      }
      if (this.a.m == 2) {}
      for (paramMenuItem = "Clk_lastactivetime";; paramMenuItem = "Clk_jointime")
      {
        this.a.a(paramMenuItem, "1", this.a.o);
        break;
      }
      label434:
      this.a.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelectionFromTop(0, -this.a.getResources().getDimensionPixelSize(2131298885));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.4
 * JD-Core Version:    0.7.0.1
 */