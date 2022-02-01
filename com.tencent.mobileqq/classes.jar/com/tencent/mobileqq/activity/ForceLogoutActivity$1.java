package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForceLogoutActivity$1
  implements View.OnClickListener
{
  ForceLogoutActivity$1(ForceLogoutActivity paramForceLogoutActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    Intent localIntent = new Intent().addFlags(67108864);
    RouteUtils.a(this.a, localIntent, "/base/login");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForceLogoutActivity.1
 * JD-Core Version:    0.7.0.1
 */