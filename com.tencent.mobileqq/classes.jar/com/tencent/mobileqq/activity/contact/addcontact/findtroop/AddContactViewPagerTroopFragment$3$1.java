package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddContactViewPagerTroopFragment$3$1
  implements View.OnClickListener
{
  AddContactViewPagerTroopFragment$3$1(AddContactViewPagerTroopFragment.3 param3) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc00899", "Grp_find_new", "", "grptab", "seach_clk", 0, 0, this.a.a.c, this.a.a.a, "", "");
    Intent localIntent = new Intent(this.a.a.getBaseActivity(), SearchContactsActivity.class);
    localIntent.putExtra("from_key", 1);
    localIntent.putExtra("fromType", 13);
    this.a.a.getBaseActivity().startActivity(localIntent);
    this.a.a.getBaseActivity().overridePendingTransition(0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment.3.1
 * JD-Core Version:    0.7.0.1
 */