package com.tencent.mobileqq.activity.contact.troop;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

class TroopActivity$8
  implements View.OnClickListener
{
  TroopActivity$8(TroopActivity paramTroopActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      this.a.b();
      break;
    case 2131436194: 
      ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right", 0, 0, "", "", "", "");
      if (this.a.c())
      {
        this.a.b();
      }
      else
      {
        ReportController.b(this.a.app, "CliOper", "", "", "Grp", "Clk_grplist_plus", 0, 0, "", "", "", "");
        this.a.a();
      }
      break;
    case 2131436180: 
    case 2131436666: 
    case 2131448219: 
      if (this.a.u != null)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("isDataChanged", this.a.u.isEmpty() ^ true);
        this.a.setResult(-1, localIntent);
      }
      this.a.onBackPressed();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity.8
 * JD-Core Version:    0.7.0.1
 */