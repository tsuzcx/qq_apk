package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.util.WeakReference;

class PositionActivatePage$3
  implements View.OnClickListener
{
  PositionActivatePage$3(PositionActivatePage paramPositionActivatePage) {}
  
  public void onClick(View paramView)
  {
    if ((PositionActivatePage.a(this.a) != null) && (PositionActivatePage.a(this.a).get() != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("ENTER_TIME", System.currentTimeMillis());
      localIntent.putExtra("FROM_WHERE", 1002);
      localIntent.putExtra("is_skip_nearby_guide", true);
      localIntent.setFlags(67108864);
      RouteUtils.a((Context)PositionActivatePage.a(this.a).get(), localIntent, "/nearby/activity");
      ReportController.b(((ActivateFriendActivity)PositionActivatePage.a(this.a).get()).app, "CliOper", "", "", "0X8004E07", "0X8004E07", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.PositionActivatePage.3
 * JD-Core Version:    0.7.0.1
 */