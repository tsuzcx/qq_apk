package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddContactViewPagerTroopFragment$2
  implements View.OnClickListener
{
  AddContactViewPagerTroopFragment$2(AddContactViewPagerTroopFragment paramAddContactViewPagerTroopFragment) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "onclick requestLBSPermissionOnClickListener");
    }
    ReportController.b(null, "dc00899", "Grp_find_new", "", "grptab", "location_set_exp", 0, 0, "", "", "", "");
    this.a.getBaseActivity().requestPermissions(new AddContactViewPagerTroopFragment.2.1(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment.2
 * JD-Core Version:    0.7.0.1
 */