package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.util.WeakReference;

class PositionActivatePage$2
  implements View.OnClickListener
{
  PositionActivatePage$2(PositionActivatePage paramPositionActivatePage) {}
  
  public void onClick(View paramView)
  {
    if ((PositionActivatePage.a(this.a) != null) && (PositionActivatePage.a(this.a).get() != null))
    {
      Intent localIntent = new Intent((Context)PositionActivatePage.a(this.a).get(), SendBirthdayWishesActivity.class);
      localIntent.putExtra("key_msg_type", 1);
      localIntent.putExtra("key_friend_list", this.a.i.getCheckedFriends());
      localIntent.putExtra("key_roam_city", this.a.k);
      ((ActivateFriendActivity)PositionActivatePage.a(this.a).get()).startActivityForResult(localIntent, 1000);
      ((ActivateFriendActivity)PositionActivatePage.a(this.a).get()).overridePendingTransition(2130771996, 2130772007);
      ReportController.b(((ActivateFriendActivity)PositionActivatePage.a(this.a).get()).app, "CliOper", "", "", "0X8004E06", "0X8004E06", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.PositionActivatePage.2
 * JD-Core Version:    0.7.0.1
 */