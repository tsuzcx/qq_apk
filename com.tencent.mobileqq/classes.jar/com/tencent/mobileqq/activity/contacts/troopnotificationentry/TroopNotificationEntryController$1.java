package com.tencent.mobileqq.activity.contacts.troopnotificationentry;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopNotificationEntryController$1
  implements View.OnClickListener
{
  TroopNotificationEntryController$1(TroopNotificationEntryController paramTroopNotificationEntryController) {}
  
  public void onClick(View paramView)
  {
    if (TroopNotificationEntryController.a(this.a) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReportController.b(null, "dc00898", "", "", "0X800B41B", "0X800B41B", 0, 0, "", "", null, null);
      Intent localIntent = new Intent();
      localIntent.putExtra("key_tab_mode", 2);
      localIntent.setClass(TroopNotificationEntryController.a(this.a), TroopActivity.class);
      localIntent.putExtra("key_from", 2);
      if (GroupSystemMsgController.a().a(TroopNotificationEntryController.a(this.a)) > 0) {
        ReportController.b(null, "dc00898", "", "", "0X800B52B", "0X800B52B", 0, 0, "", "", null, null);
      }
      if (TroopNotifyHelper.a())
      {
        TroopNotifyHelper.a(false);
        TroopNotifyHelper.a();
        localIntent.putExtra("show_type", true);
        ReportController.b(null, "dc00898", "", "", "0X800B52F", "0X800B52F", 0, 0, "", "", null, null);
      }
      TroopNotificationEntryController.a(this.a).startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troopnotificationentry.TroopNotificationEntryController.1
 * JD-Core Version:    0.7.0.1
 */