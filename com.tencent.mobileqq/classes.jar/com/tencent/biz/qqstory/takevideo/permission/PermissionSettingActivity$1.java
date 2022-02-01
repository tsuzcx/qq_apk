package com.tencent.biz.qqstory.takevideo.permission;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PermissionSettingActivity$1
  implements View.OnClickListener
{
  PermissionSettingActivity$1(PermissionSettingActivity paramPermissionSettingActivity) {}
  
  public void onClick(View paramView)
  {
    PermissionPart localPermissionPart = PermissionSettingActivity.a(this.a).a();
    if (localPermissionPart != null)
    {
      PermissionSettingActivity.a(this.a, localPermissionPart);
      this.a.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity.1
 * JD-Core Version:    0.7.0.1
 */