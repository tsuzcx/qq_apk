package com.tencent.mobileqq.activity;

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

class TroopMemberListActivity$3
  implements PopupMenuDialog.OnClickActionListener
{
  TroopMemberListActivity$3(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    if (paramMenuItem.a == this.a.jdField_m_of_type_Int) {
      return;
    }
    this.a.jdField_m_of_type_Int = paramMenuItem.a;
    TroopMemberListActivity.a(this.a, paramMenuItem.a);
    if ((this.a.jdField_m_of_type_Int >= 0) && (this.a.jdField_m_of_type_Int < TroopMemberListActivity.a(this.a).length)) {
      this.a.c.setText(TroopMemberListActivity.a(this.a)[this.a.jdField_m_of_type_Int]);
    }
    if (this.a.jdField_m_of_type_Int == 0)
    {
      this.a.a("Clk_def", this.a.n, "");
      this.a.h();
      if (!this.a.jdField_m_of_type_Boolean) {
        this.a.jdField_m_of_type_Boolean = true;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
      }
      if (this.a.jdField_m_of_type_Int != 0) {
        break label474;
      }
      this.a.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelectionFromTop(0, 0);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription(this.a.jdField_b_of_type_AndroidWidgetTextView.getText().toString() + this.a.c.getText().toString());
      return;
      if (this.a.jdField_m_of_type_Int == 1)
      {
        ((TroopHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).t(this.a.jdField_b_of_type_JavaLangString);
        new ReportTask(this.a.app).a("dc00899").b("Grp_online").c("mber_list").d("exp_onlineList").a(0).a(new String[] { this.a.jdField_b_of_type_JavaLangString }).a();
        new ReportTask(this.a.app).a("dc00899").b("Grp_online").c("mber_list").d("clk_onlinefirst").a(new String[] { this.a.jdField_b_of_type_JavaLangString }).a();
        break;
      }
      if (this.a.jdField_m_of_type_Int == 5)
      {
        ((TroopHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).u(this.a.jdField_b_of_type_JavaLangString);
        break;
      }
      if (this.a.jdField_m_of_type_Int == 2) {}
      for (paramMenuItem = "Clk_lastactivetime";; paramMenuItem = "Clk_jointime")
      {
        this.a.a(paramMenuItem, "1", this.a.n);
        break;
      }
      label474:
      this.a.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelectionFromTop(0, -this.a.getResources().getDimensionPixelSize(2131298885));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.3
 * JD-Core Version:    0.7.0.1
 */