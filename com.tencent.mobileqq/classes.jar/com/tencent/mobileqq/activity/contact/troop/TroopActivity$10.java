package com.tencent.mobileqq.activity.contact.troop;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

class TroopActivity$10
  implements View.OnClickListener
{
  TroopActivity$10(TroopActivity paramTroopActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    switch (paramView.getId())
    {
    default: 
      this.a.b();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.a != null)
      {
        Intent localIntent = new Intent();
        if (!this.a.a.isEmpty()) {
          bool = true;
        }
        localIntent.putExtra("isDataChanged", bool);
        this.a.setResult(-1, localIntent);
      }
      this.a.onBackPressed();
      continue;
      ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right", 0, 0, "", "", "", "");
      if (this.a.a())
      {
        this.a.b();
      }
      else
      {
        ReportController.b(this.a.app, "CliOper", "", "", "Grp", "Clk_grplist_plus", 0, 0, "", "", "", "");
        this.a.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity.10
 * JD-Core Version:    0.7.0.1
 */