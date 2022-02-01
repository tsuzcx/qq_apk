package com.tencent.mobileqq.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.adapter.contact.TroopListItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopListAdapter2$5
  implements View.OnClickListener
{
  TroopListAdapter2$5(TroopListAdapter2 paramTroopListAdapter2) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof TroopListAdapter2.TroopListViewItemTag))
    {
      localObject = (TroopListAdapter2.TroopListViewItemTag)localObject;
      if ((((TroopListAdapter2.TroopListViewItemTag)localObject).a != null) && (((TroopListAdapter2.TroopListViewItemTag)localObject).a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$OnTroopListClickListener.a(((TroopListAdapter2.TroopListViewItemTag)localObject).a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, ((TroopListAdapter2.TroopListViewItemTag)localObject).a.jdField_a_of_type_Int);
      }
      if ((((TroopListAdapter2.TroopListViewItemTag)localObject).a != null) && (((TroopListAdapter2.TroopListViewItemTag)localObject).a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$OnTroopListClickListener.a(((TroopListAdapter2.TroopListViewItemTag)localObject).a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo);
      }
      new ReportTask(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("send_to").d("clk_grp").a(new String[] { "1" }).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopListAdapter2.5
 * JD-Core Version:    0.7.0.1
 */