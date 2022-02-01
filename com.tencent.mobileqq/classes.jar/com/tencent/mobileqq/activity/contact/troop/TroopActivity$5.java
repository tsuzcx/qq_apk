package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.util.MqqWeakReferenceHandler;

class TroopActivity$5
  implements TabBarView.OnTabChangeListener
{
  TroopActivity$5(TroopActivity paramTroopActivity) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (this.a.A != null) {
      this.a.A.b();
    }
    if (this.a.f != 2)
    {
      if (paramInt2 != 0)
      {
        if (paramInt2 != 1)
        {
          ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_mygrp", 0, 0, "", "", "", "");
          ReportController.b(this.a.app, "CliOper", "", "", "0X8006620", "0X8006620", 0, 0, "", "", "", "");
          this.a.e = 0;
        }
        else
        {
          ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "discuss", "contact_discuss_tab", 0, 0, "", "", "", "");
          ReportController.b(this.a.app, "CliOper", "", "", "0X8006621", "0X8006621", 0, 0, "", "", "", "");
          this.a.e = 1;
        }
      }
      else
      {
        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_mygrp", 0, 0, "", "", "", "");
        ReportController.b(this.a.app, "CliOper", "", "", "0X8006620", "0X8006620", 0, 0, "", "", "", "");
        this.a.e = 0;
      }
    }
    else if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (this.a.k.b(1).a()) {
          localObject = "0";
        } else {
          localObject = "1";
        }
        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_grpnotice", 0, 0, "", (String)localObject, "", "");
        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_verify", 0, 0, "", "", "", "");
        this.a.e = 1;
      }
      else
      {
        if (this.a.k.b(1).a()) {
          localObject = "0";
        } else {
          localObject = "1";
        }
        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_grpnotice", 0, 0, "", (String)localObject, "", "");
        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_verify", 0, 0, "", "", "", "");
        this.a.e = 1;
      }
    }
    else
    {
      if (this.a.k.b(0).a()) {
        localObject = "0";
      } else {
        localObject = "1";
      }
      ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_grprecom", 0, 0, "", (String)localObject, "", "");
      ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_recom", 0, 0, "", "", "", "");
      this.a.e = 0;
    }
    Object localObject = this.a;
    ((TroopActivity)localObject).a(((TroopActivity)localObject).e);
    this.a.o.sendEmptyMessage(1234);
    TroopActivity.a(this.a, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity.5
 * JD-Core Version:    0.7.0.1
 */