package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.IAddContactContext;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopView$11
  implements View.OnClickListener
{
  TroopView$11(TroopView paramTroopView) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a.E.b(), SearchContactsActivity.class);
    localIntent.putExtra("from_key", 1);
    localIntent.putExtra("fromType", 13);
    this.a.E.b().startActivity(localIntent);
    this.a.E.b().overridePendingTransition(0, 0);
    SearchUtils.a("add_page", "search", "active_frame", 2, 0, new String[] { "" });
    ReportController.b(this.a.G, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 2, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView.11
 * JD-Core Version:    0.7.0.1
 */