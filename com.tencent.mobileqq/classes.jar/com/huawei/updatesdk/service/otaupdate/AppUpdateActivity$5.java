package com.huawei.updatesdk.service.otaupdate;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AppUpdateActivity$5
  implements View.OnClickListener
{
  AppUpdateActivity$5(AppUpdateActivity paramAppUpdateActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    AppUpdateActivity.a(this.b, this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.AppUpdateActivity.5
 * JD-Core Version:    0.7.0.1
 */