package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

class TroopAssistantActivity$15
  implements PopupMenuDialog.OnClickActionListener
{
  TroopAssistantActivity$15(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onClickAction(PopupMenuDialog.MenuItem paramMenuItem)
  {
    int i = paramMenuItem.id;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      paramMenuItem = new Intent(this.a, TroopAssisSettingActivity.class);
      paramMenuItem.setFlags(67108864);
      this.a.startActivity(paramMenuItem);
      ReportController.b(this.a.app, "P_CliOper", "Grp_msg", "", "help_list", "Clk_set", 0, 0, "", "", "", "");
      return;
    }
    paramMenuItem = this.a;
    paramMenuItem.d = (true ^ paramMenuItem.d);
    TroopAssistantManager.a().b(this.a.app, this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.15
 * JD-Core Version:    0.7.0.1
 */