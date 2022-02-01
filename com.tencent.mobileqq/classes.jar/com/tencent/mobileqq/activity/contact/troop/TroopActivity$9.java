package com.tencent.mobileqq.activity.contact.troop;

import android.content.Intent;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

class TroopActivity$9
  implements PopupMenuDialog.OnClickActionListener
{
  TroopActivity$9(TroopActivity paramTroopActivity) {}
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    switch (paramMenuItem.a)
    {
    default: 
    case 0: 
      do
      {
        return;
        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_create", 0, 0, "", "", "", "");
        ReportController.b(this.a.app, "CliOper", "", "", "0X8006622", "0X8006622", 0, 0, "", "", "", "");
        paramMenuItem = (TroopCreateLogic)this.a.app.getManager(QQManagerFactory.MGR_TROOP_CREATE);
      } while (paramMenuItem == null);
      paramMenuItem.a(this.a, 0);
      return;
    case 1: 
      ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_join", 0, 0, "", "", "", "");
      ReportController.b(this.a.app, "CliOper", "", "", "Grp", "grplist_plus_join", 47, 0, "", "", "", "");
      AddContactsActivity.a(this.a, 1);
      return;
    case 2: 
      ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_msgset", 0, 0, "", "", "", "");
      ReportController.b(this.a.app, "CliOper", "", "", "Grp", "grplist_plus_setting", 0, 0, "", "", "", "");
      paramMenuItem = new Intent(this.a, TroopAssisSettingActivity.class);
      this.a.startActivity(paramMenuItem);
      return;
    }
    TroopActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity.9
 * JD-Core Version:    0.7.0.1
 */