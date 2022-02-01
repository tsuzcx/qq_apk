package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

class TroopAssistantActivity$13
  implements PopupMenuDialog.OnClickActionListener
{
  TroopAssistantActivity$13(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    boolean bool = false;
    switch (paramMenuItem.a)
    {
    default: 
      return;
    case 0: 
      paramMenuItem = this.a;
      if (!this.a.d) {
        bool = true;
      }
      paramMenuItem.d = bool;
      TroopAssistantManager.a().b(this.a.app, this.a.d);
      return;
    }
    paramMenuItem = new Intent(this.a, TroopAssisSettingActivity.class);
    paramMenuItem.setFlags(67108864);
    this.a.startActivity(paramMenuItem);
    ReportController.b(this.a.app, "P_CliOper", "Grp_msg", "", "help_list", "Clk_set", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.13
 * JD-Core Version:    0.7.0.1
 */