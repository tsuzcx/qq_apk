package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.theme.NightModeLogic.NightModeCallback;
import com.tencent.qphone.base.util.QLog;

class QQSettingMe$39
  implements NightModeLogic.NightModeCallback
{
  QQSettingMe$39(QQSettingMe paramQQSettingMe) {}
  
  public void a(Bundle paramBundle)
  {
    this.a.m();
  }
  
  public void b(Bundle paramBundle)
  {
    int i = paramBundle.getInt("start_status");
    if (i == 1) {
      this.a.m();
    }
    do
    {
      do
      {
        return;
        if (i == 2)
        {
          this.a.m();
          return;
        }
      } while (i != 3);
      if (!(this.a.d.getDrawable() instanceof Animatable)) {
        break;
      }
      i = paramBundle.getInt("percent");
      paramBundle = String.valueOf(i) + "%";
      this.a.c.setText(paramBundle);
    } while (!QLog.isDevelopLevel());
    QLog.d("QQSettingRedesign", 4, "NIGHTMODE_ACTION_DOWNLOADING: " + i);
    return;
    if (QQSettingMe.f(this.a)) {}
    for (Drawable localDrawable = this.a.a.getResources().getDrawable(2130846370);; localDrawable = this.a.a.getResources().getDrawable(2130846371))
    {
      this.a.d.setImageDrawable(localDrawable);
      if (!(localDrawable instanceof Animatable)) {
        break;
      }
      ((Animatable)localDrawable).start();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.39
 * JD-Core Version:    0.7.0.1
 */