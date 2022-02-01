package com.tencent.biz.addContactTroopView;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.im.troop_search_searchtab.searchtab.Card;
import tencent.im.troop_search_searchtab.searchtab.TitleBar;

class TroopCardSameCity$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    this.a.a(this.a.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.str_transfer_url.get());
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "grptab", "Clk_more", 0, 0, "", this.a.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.title_bar.str_desc.get(), "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardSameCity.2
 * JD-Core Version:    0.7.0.1
 */