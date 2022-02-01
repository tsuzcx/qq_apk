package com.tencent.mobileqq.activity.contact.troop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NotifyAndRecAdapter$1
  implements View.OnClickListener
{
  NotifyAndRecAdapter$1(NotifyAndRecAdapter paramNotifyAndRecAdapter, View paramView) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(NotifyAndRecAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter), "dc00899", "Grp_contacts_news", "", "notice", "verify_clk", 0, 0, "", "", "", "");
    NotifyAndRecAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter, true);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.notifyDataSetChanged();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.NotifyAndRecAdapter.1
 * JD-Core Version:    0.7.0.1
 */