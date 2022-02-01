package com.tencent.biz.pubaccount.readinjoy;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DailyDynamicHeaderViewController$4
  implements View.OnClickListener
{
  DailyDynamicHeaderViewController$4(DailyDynamicHeaderViewController paramDailyDynamicHeaderViewController) {}
  
  public void onClick(View paramView)
  {
    QLog.i("DailyHeaderViewController", 1, "[onClick] clickToGrantPermission");
    BaseActivity localBaseActivity = (BaseActivity)paramView.getContext();
    if (Build.VERSION.SDK_INT >= 23) {
      if (localBaseActivity.shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION")) {
        DailyDynamicHeaderViewController.a(this.a, true);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localBaseActivity.requestPermissions(new DailyDynamicHeaderViewController.4.1(this, localBaseActivity), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      continue;
      DailyDynamicHeaderViewController.a(this.a, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.DailyDynamicHeaderViewController.4
 * JD-Core Version:    0.7.0.1
 */