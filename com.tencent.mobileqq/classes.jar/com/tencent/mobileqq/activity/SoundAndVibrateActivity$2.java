package com.tencent.mobileqq.activity;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import mqq.app.AppRuntime;

class SoundAndVibrateActivity$2
  implements CompoundButton.OnCheckedChangeListener
{
  SoundAndVibrateActivity$2(SoundAndVibrateActivity paramSoundAndVibrateActivity, String paramString) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity;
    SettingCloneUtil.writeValue((Context)localObject1, this.jdField_a_of_type_JavaLangString, ((SoundAndVibrateActivity)localObject1).getString(2131718135), "qqsetting_lock_screen_whenexit_key", paramBoolean);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity.app;
    if (paramBoolean) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X80040D9", "0X80040D9", 0, 0, (String)localObject1, "", "", "");
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("collectPerformance qqls setting isChecked=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.i("qqls", 4, ((StringBuilder)localObject1).toString());
    }
    localObject1 = new HashMap();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append("");
    ((HashMap)localObject1).put("param_ls_setting", ((StringBuilder)localObject2).toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity.app.getCurrentAccountUin(), "qqlsSettingReprotTag", true, 0L, 0L, (HashMap)localObject1, "");
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SoundAndVibrateActivity.2
 * JD-Core Version:    0.7.0.1
 */