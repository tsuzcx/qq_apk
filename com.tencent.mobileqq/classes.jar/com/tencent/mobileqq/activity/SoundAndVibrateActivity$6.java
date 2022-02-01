package com.tencent.mobileqq.activity;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

class SoundAndVibrateActivity$6
  implements View.OnClickListener
{
  SoundAndVibrateActivity$6(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.b(3);
    Object localObject = this.a;
    SettingCloneUtil.writeValueForInt((Context)localObject, ((SoundAndVibrateActivity)localObject).app.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.h);
    if (this.a.b().booleanValue())
    {
      this.a.c();
      localObject = ThemeUtil.getThemeVoiceRootPath();
      if (localObject != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(File.separatorChar);
        localStringBuilder.append("message.mp3");
        localObject = new File(localStringBuilder.toString());
        if (((File)localObject).exists())
        {
          this.a.c();
          this.a.a(Uri.fromFile((File)localObject));
          break label195;
        }
      }
      this.a.c();
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("android.resource://");
      localStringBuilder.append(this.a.getApplicationContext().getPackageName());
      localStringBuilder.append("/");
      localStringBuilder.append(2131230721);
      ((SoundAndVibrateActivity)localObject).a(Uri.parse(localStringBuilder.toString()));
    }
    label195:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SoundAndVibrateActivity.6
 * JD-Core Version:    0.7.0.1
 */