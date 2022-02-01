package com.tencent.mobileqq.activity.recent.msgbox;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.TempMsgSettingFragment;
import com.tencent.mobileqq.settings.config.SettingsConfigHelper;
import com.tencent.mobileqq.settings.message.NewTempMsgSettingFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TempMsgBoxFragment$4
  implements View.OnClickListener
{
  TempMsgBoxFragment$4(TempMsgBoxFragment paramTempMsgBoxFragment) {}
  
  public void onClick(View paramView)
  {
    if (SettingsConfigHelper.a(this.a.a)) {
      PublicFragmentActivity.a(TempMsgBoxFragment.a(this.a), NewTempMsgSettingFragment.class);
    }
    for (;;)
    {
      ReportController.b(this.a.a, "dc00898", "", "", "0X800B1C1", "0X800B1C1", 0, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      PublicFragmentActivity.a(TempMsgBoxFragment.a(this.a), TempMsgSettingFragment.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxFragment.4
 * JD-Core Version:    0.7.0.1
 */