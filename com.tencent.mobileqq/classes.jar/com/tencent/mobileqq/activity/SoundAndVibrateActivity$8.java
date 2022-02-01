package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SoundAndVibrateActivity$8
  implements CompoundButton.OnCheckedChangeListener
{
  SoundAndVibrateActivity$8(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    label61:
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      SoundAndVibrateActivity.b(this.a, 0);
      SoundAndVibrateActivity.e(this.a).setBackgroundResource(2130839591);
      if (this.a.app.getTroopGeneralSettingVibrate() == 0)
      {
        this.a.b.setChecked(false);
        this.a.app.setALLGeneralSettingVibrate(1);
        localQQAppInterface = this.a.app;
        if (!paramBoolean) {
          break label157;
        }
      }
    }
    for (;;)
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_notice_shake", 0, i, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      this.a.b.setChecked(true);
      break;
      SoundAndVibrateActivity.b(this.a, 8);
      SoundAndVibrateActivity.e(this.a).setBackgroundResource(2130839575);
      this.a.app.setALLGeneralSettingVibrate(0);
      break label61;
      label157:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SoundAndVibrateActivity.8
 * JD-Core Version:    0.7.0.1
 */