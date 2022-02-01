package com.tencent.mobileqq.activity.contact.addcontact;

import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddContactsActivity$1
  implements RadioGroup.OnCheckedChangeListener
{
  AddContactsActivity$1(AddContactsActivity paramAddContactsActivity) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    int i = 8;
    if ((paramInt == 2131446741) && (AddContactsActivity.a(this.a).isChecked()))
    {
      AddContactsActivity.b(this.a);
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004BE9", "0X8004BE9", 0, 0, "", "", "", "");
      AddContactsActivity.a(this.a).setSelected(true);
      AddContactsActivity.c(this.a).setSelected(false);
      AddContactsActivity.d(this.a).setSelected(false);
      AddContactsActivity.e(this.a).setVisibility(8);
    }
    else if ((paramInt == 2131446743) && (AddContactsActivity.c(this.a).isChecked()))
    {
      AddContactsActivity.f(this.a);
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004BEA", "0X8004BEA", 0, 0, "", "", "", "");
      ReportController.b(this.a.app, "P_CliOper", "Grp_find", "", "grptab", "exp", 0, 0, "", "", "", "");
      AddContactsActivity.c(this.a).setSelected(true);
      AddContactsActivity.a(this.a).setSelected(false);
      AddContactsActivity.d(this.a).setSelected(false);
      ImageView localImageView = AddContactsActivity.e(this.a);
      if (AddContactsActivity.g(this.a)) {
        i = 0;
      }
      localImageView.setVisibility(i);
    }
    else if ((paramInt == 2131446742) && (AddContactsActivity.d(this.a).isChecked()))
    {
      AddContactsActivity.h(this.a);
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004BEB", "0X8004BEB", 0, 0, "", "", "", "");
      AddContactsActivity.d(this.a).setSelected(true);
      AddContactsActivity.a(this.a).setSelected(false);
      AddContactsActivity.c(this.a).setSelected(false);
      AddContactsActivity.e(this.a).setVisibility(8);
    }
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity.1
 * JD-Core Version:    0.7.0.1
 */