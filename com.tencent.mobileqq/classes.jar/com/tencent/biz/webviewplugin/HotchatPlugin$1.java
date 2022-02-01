package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HotchatPlugin$1
  implements View.OnClickListener
{
  HotchatPlugin$1(HotchatPlugin paramHotchatPlugin, String paramString, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    this.c.callJs(this.a, new String[] { "" });
    Object localObject = this.b;
    if ((localObject instanceof QBaseActivity))
    {
      localObject = ((QBaseActivity)localObject).getAppRuntime();
      if ((localObject instanceof INearbyAppInterface)) {
        ((INearbyAppInterface)localObject).nearbyReportClickEvent("dc00899", "grp_lbs", "", "hot_create", "clk_create", 0, 0, "", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.HotchatPlugin.1
 * JD-Core Version:    0.7.0.1
 */