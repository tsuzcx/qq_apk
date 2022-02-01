package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.util.MqqWeakReferenceHandler;

class TroopActivity$7
  implements TabBarView.OnTabChangeListener
{
  TroopActivity$7(TroopActivity paramTroopActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.b();
    }
    if (this.a.b != 2)
    {
      switch (paramInt2)
      {
      default: 
        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_mygrp", 0, 0, "", "", "", "");
        ReportController.b(this.a.app, "CliOper", "", "", "0X8006620", "0X8006620", 0, 0, "", "", "", "");
        this.a.jdField_a_of_type_Int = 0;
      }
      for (;;)
      {
        this.a.a(this.a.jdField_a_of_type_Int);
        this.a.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(1234);
        TroopActivity.a(this.a, paramInt2);
        return;
        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_mygrp", 0, 0, "", "", "", "");
        ReportController.b(this.a.app, "CliOper", "", "", "0X8006620", "0X8006620", 0, 0, "", "", "", "");
        this.a.jdField_a_of_type_Int = 0;
        continue;
        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "discuss", "contact_discuss_tab", 0, 0, "", "", "", "");
        ReportController.b(this.a.app, "CliOper", "", "", "0X8006621", "0X8006621", 0, 0, "", "", "", "");
        this.a.jdField_a_of_type_Int = 1;
      }
    }
    switch (paramInt2)
    {
    default: 
      if (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).a()) {
        break;
      }
    }
    for (String str = "0";; str = "1")
    {
      ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_grpnotice", 0, 0, "", str, "", "");
      ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_verify", 0, 0, "", "", "", "");
      this.a.jdField_a_of_type_Int = 1;
      break;
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).a()) {}
      for (str = "0";; str = "1")
      {
        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_grpnotice", 0, 0, "", str, "", "");
        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_verify", 0, 0, "", "", "", "");
        this.a.jdField_a_of_type_Int = 1;
        break;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).a()) {}
      for (str = "0";; str = "1")
      {
        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_grprecom", 0, 0, "", str, "", "");
        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_recom", 0, 0, "", "", "", "");
        this.a.jdField_a_of_type_Int = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity.7
 * JD-Core Version:    0.7.0.1
 */