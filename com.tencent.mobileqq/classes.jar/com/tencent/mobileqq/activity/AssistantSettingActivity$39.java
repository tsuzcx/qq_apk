package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingActivity$39
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingActivity$39(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!NetworkUtil.isNetSupport(this.a))
    {
      AssistantSettingActivity.a(this.a, 2131694473, 1);
      AssistantSettingActivity.b(this.a, paramBoolean ^ true);
    }
    else
    {
      QQAppInterface localQQAppInterface = this.a.app;
      String str;
      if (paramBoolean) {
        str = "1";
      } else {
        str = "2";
      }
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A5D5", "0X800A5D5", 0, 0, str, "", "", "");
      this.a.a.b(paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.39
 * JD-Core Version:    0.7.0.1
 */