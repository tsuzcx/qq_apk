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
    if ((paramInt == 2131378223) && (AddContactsActivity.a(this.a).isChecked()))
    {
      AddContactsActivity.a(this.a);
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004BE9", "0X8004BE9", 0, 0, "", "", "", "");
      AddContactsActivity.a(this.a).setSelected(true);
      AddContactsActivity.b(this.a).setSelected(false);
      AddContactsActivity.c(this.a).setSelected(false);
      AddContactsActivity.a(this.a).setVisibility(8);
    }
    else if ((paramInt == 2131378225) && (AddContactsActivity.b(this.a).isChecked()))
    {
      AddContactsActivity.b(this.a);
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004BEA", "0X8004BEA", 0, 0, "", "", "", "");
      ReportController.b(this.a.app, "P_CliOper", "Grp_find", "", "grptab", "exp", 0, 0, "", "", "", "");
      AddContactsActivity.b(this.a).setSelected(true);
      AddContactsActivity.a(this.a).setSelected(false);
      AddContactsActivity.c(this.a).setSelected(false);
      ImageView localImageView = AddContactsActivity.a(this.a);
      if (AddContactsActivity.a(this.a)) {
        i = 0;
      }
      localImageView.setVisibility(i);
    }
    else if ((paramInt == 2131378224) && (AddContactsActivity.c(this.a).isChecked()))
    {
      AddContactsActivity.c(this.a);
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004BEB", "0X8004BEB", 0, 0, "", "", "", "");
      AddContactsActivity.c(this.a).setSelected(true);
      AddContactsActivity.a(this.a).setSelected(false);
      AddContactsActivity.b(this.a).setSelected(false);
      AddContactsActivity.a(this.a).setVisibility(8);
    }
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity.1
 * JD-Core Version:    0.7.0.1
 */