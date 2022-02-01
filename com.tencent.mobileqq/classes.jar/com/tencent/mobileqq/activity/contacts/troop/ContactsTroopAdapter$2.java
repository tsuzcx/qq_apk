package com.tencent.mobileqq.activity.contacts.troop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactsTroopAdapter$2
  implements View.OnClickListener
{
  ContactsTroopAdapter$2(ContactsTroopAdapter paramContactsTroopAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int] = 2;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.notifyDataSetChanged();
    int i = ContactsTroopAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter, this.jdField_a_of_type_Int);
    new ReportTask(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_inactive").a(new String[] { "", String.valueOf(i) }).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter.2
 * JD-Core Version:    0.7.0.1
 */