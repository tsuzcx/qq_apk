package com.tencent.mobileqq.activity;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

class SoundAndVibrateActivity$6
  implements View.OnClickListener
{
  SoundAndVibrateActivity$6(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.b(3);
    SettingCloneUtil.writeValueForInt(this.a, this.a.app.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.b);
    if (this.a.a().booleanValue())
    {
      this.a.b();
      Object localObject = ThemeUtil.getThemeVoiceRootPath();
      if (localObject == null) {
        break label126;
      }
      localObject = new File((String)localObject + File.separatorChar + "message.mp3");
      if (!((File)localObject).exists()) {
        break label126;
      }
      this.a.b();
      this.a.a(Uri.fromFile((File)localObject));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label126:
      this.a.b();
      this.a.a(Uri.parse("android.resource://" + this.a.getApplicationContext().getPackageName() + "/" + 2131230721));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SoundAndVibrateActivity.6
 * JD-Core Version:    0.7.0.1
 */