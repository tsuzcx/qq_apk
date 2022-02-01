package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.QQSettingChatOperationFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GeneralSettingActivity$4
  implements View.OnClickListener
{
  GeneralSettingActivity$4(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("set_display_type", 1);
    PublicFragmentActivity.a(this.a.getActivity(), localIntent, QQSettingChatOperationFragment.class);
    ReportController.b(null, "CliOper", "", "", "0X800A22C", "0X800A22C", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.4
 * JD-Core Version:    0.7.0.1
 */