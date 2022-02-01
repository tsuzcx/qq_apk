package com.tencent.mobileqq.activity.contact.troop;

import android.content.Intent;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

class TroopActivity$7
  implements PopupMenuDialog.OnClickActionListener
{
  TroopActivity$7(TroopActivity paramTroopActivity) {}
  
  public void onClickAction(PopupMenuDialog.MenuItem paramMenuItem)
  {
    int i = paramMenuItem.id;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          TroopActivity.a(this.a);
          return;
        }
        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_msgset", 0, 0, "", "", "", "");
        ReportController.b(this.a.app, "CliOper", "", "", "Grp", "grplist_plus_setting", 0, 0, "", "", "", "");
        paramMenuItem = new Intent(this.a, TroopAssisSettingActivity.class);
        this.a.startActivity(paramMenuItem);
        return;
      }
      ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_join", 0, 0, "", "", "", "");
      ReportController.b(this.a.app, "CliOper", "", "", "Grp", "grplist_plus_join", 47, 0, "", "", "", "");
      AddContactsActivity.a(this.a, 1);
      return;
    }
    ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_create", 0, 0, "", "", "", "");
    ReportController.b(this.a.app, "CliOper", "", "", "0X8006622", "0X8006622", 0, 0, "", "", "", "");
    paramMenuItem = (ITroopCreateService)this.a.app.getRuntimeService(ITroopCreateService.class, "");
    if (paramMenuItem != null) {
      paramMenuItem.startCreateTroopSession(this.a, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity.7
 * JD-Core Version:    0.7.0.1
 */