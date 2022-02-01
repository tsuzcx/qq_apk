package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.settings.message.ChatHistorySettingFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GeneralSettingActivity$10
  implements View.OnClickListener
{
  GeneralSettingActivity$10(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.a(this.a.app, "0X800B871");
    Intent localIntent = new Intent();
    localIntent.putExtra("set_display_type", 1);
    PublicFragmentActivity.a(this.a.getActivity(), localIntent, ChatHistorySettingFragment.class);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.10
 * JD-Core Version:    0.7.0.1
 */