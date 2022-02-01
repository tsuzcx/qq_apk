package com.tencent.mobileqq.activity.aio.tips;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;

class NetStateTipsBar$1
  implements View.OnClickListener
{
  NetStateTipsBar$1(NetStateTipsBar paramNetStateTipsBar) {}
  
  public void onClick(View paramView)
  {
    if (VersionUtils.e()) {
      NetStateTipsBar.a(this.a).startActivity(new Intent("android.settings.SETTINGS"));
    } else {
      NetStateTipsBar.a(this.a).startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
    }
    ReportController.b(NetStateTipsBar.b(this.a), "dc00898", "", "", "0X800BC3D", "0X800BC3D", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.NetStateTipsBar.1
 * JD-Core Version:    0.7.0.1
 */