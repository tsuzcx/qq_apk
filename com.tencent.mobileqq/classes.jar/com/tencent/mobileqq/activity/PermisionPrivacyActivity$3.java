package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager.Utils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PermisionPrivacyActivity$3
  implements View.OnClickListener
{
  PermisionPrivacyActivity$3(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onClick(View paramView)
  {
    CustomOnlineStatusManager.Utils.a(this.a, "settings");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.3
 * JD-Core Version:    0.7.0.1
 */