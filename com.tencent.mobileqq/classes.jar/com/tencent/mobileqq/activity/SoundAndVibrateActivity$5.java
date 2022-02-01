package com.tencent.mobileqq.activity;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings.System;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SoundAndVibrateActivity$5
  implements View.OnClickListener
{
  SoundAndVibrateActivity$5(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.b(2);
    Object localObject = this.a;
    SettingCloneUtil.writeValueForInt((Context)localObject, ((SoundAndVibrateActivity)localObject).app.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.g);
    if (this.a.b().booleanValue())
    {
      localObject = Settings.System.DEFAULT_NOTIFICATION_URI;
      this.a.c();
      this.a.a((Uri)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SoundAndVibrateActivity.5
 * JD-Core Version:    0.7.0.1
 */