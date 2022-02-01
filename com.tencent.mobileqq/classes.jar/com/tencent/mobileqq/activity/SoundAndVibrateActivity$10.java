package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SoundAndVibrateActivity$10
  implements CompoundButton.OnCheckedChangeListener
{
  SoundAndVibrateActivity$10(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      this.a.app.setTroopGeneralSettingVibrate(1);
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label78;
      }
    }
    for (;;)
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_notice_grpshake", 0, i, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      this.a.app.setTroopGeneralSettingVibrate(0);
      break;
      label78:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SoundAndVibrateActivity.10
 * JD-Core Version:    0.7.0.1
 */