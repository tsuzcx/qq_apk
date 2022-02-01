package com.tencent.mobileqq.activity;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SoundAndVibrateActivity$4
  implements View.OnClickListener
{
  SoundAndVibrateActivity$4(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.b(1);
    SoundAndVibrateActivity localSoundAndVibrateActivity = this.a;
    SettingCloneUtil.writeValueForInt(localSoundAndVibrateActivity, localSoundAndVibrateActivity.app.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", 2131230721);
    if (this.a.b().booleanValue())
    {
      this.a.c();
      localSoundAndVibrateActivity = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("android.resource://");
      localStringBuilder.append(this.a.getApplicationContext().getPackageName());
      localStringBuilder.append("/");
      localStringBuilder.append(2131230721);
      localSoundAndVibrateActivity.a(Uri.parse(localStringBuilder.toString()));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SoundAndVibrateActivity.4
 * JD-Core Version:    0.7.0.1
 */