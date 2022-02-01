package com.tencent.mobileqq.activity;

import android.content.Context;
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
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131434200: 
      localObject = new Intent(this.a, GesturePWDCreateActivity.class);
      this.a.startActivityForResult((Intent)localObject, 11);
      this.a.overridePendingTransition(2130772014, 2130772007);
      break;
    case 2131434187: 
      localObject = new Intent(this.a, GesturePWDManualGuideActivity.class);
      this.a.startActivity((Intent)localObject);
      break;
    case 2131434186: 
      localObject = this.a;
      GesturePWDUtils.setGesturePWDMode((Context)localObject, ((GesturePWDSettingActivity)localObject).app.getCurrentAccountUin(), 20);
      this.a.a();
      break;
    case 2131434183: 
      localObject = this.a;
      GesturePWDUtils.setGesturePWDMode((Context)localObject, ((GesturePWDSettingActivity)localObject).app.getCurrentAccountUin(), 21);
      this.a.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDSettingActivity.2
 * JD-Core Version:    0.7.0.1
 */