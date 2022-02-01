package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.VipUtils.VipIconUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PermisionPrivacyActivity$1
  implements View.OnClickListener
{
  PermisionPrivacyActivity$1(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onClick(View paramView)
  {
    VipUtils.VipIconUtils.a(this.a.app, this.a, "setting");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.1
 * JD-Core Version:    0.7.0.1
 */