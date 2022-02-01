package com.tencent.mobileqq.activity;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SoundAndVibrateActivity$3
  implements View.OnClickListener
{
  SoundAndVibrateActivity$3(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.b(0);
    SoundAndVibrateActivity localSoundAndVibrateActivity = this.a;
    SettingCloneUtil.writeValueForInt(localSoundAndVibrateActivity, localSoundAndVibrateActivity.app.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", 2131230720);
    if (this.a.a().booleanValue())
    {
      this.a.b();
      localSoundAndVibrateActivity = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("android.resource://");
      localStringBuilder.append(this.a.getApplicationContext().getPackageName());
      localStringBuilder.append("/");
      localStringBuilder.append(2131230720);
      localSoundAndVibrateActivity.a(Uri.parse(localStringBuilder.toString()));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SoundAndVibrateActivity.3
 * JD-Core Version:    0.7.0.1
 */