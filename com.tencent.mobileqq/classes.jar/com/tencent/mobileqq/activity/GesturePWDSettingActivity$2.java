package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GesturePWDSettingActivity$2
  implements View.OnClickListener
{
  GesturePWDSettingActivity$2(GesturePWDSettingActivity paramGesturePWDSettingActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      GesturePWDUtils.setGesturePWDMode(this.a, this.a.app.getCurrentAccountUin(), 20);
      this.a.a();
      continue;
      GesturePWDUtils.setGesturePWDMode(this.a, this.a.app.getCurrentAccountUin(), 21);
      this.a.a();
      continue;
      Intent localIntent = new Intent(this.a, GesturePWDManualGuideActivity.class);
      this.a.startActivity(localIntent);
      continue;
      localIntent = new Intent(this.a, GesturePWDCreateActivity.class);
      this.a.startActivityForResult(localIntent, 11);
      this.a.overridePendingTransition(2130771999, 2130771992);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDSettingActivity.2
 * JD-Core Version:    0.7.0.1
 */