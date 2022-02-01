package com.tencent.mobileqq.activity.qqsettingme;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.vas.theme.NightModeLogic.NightModeCallback;

class QQSettingMeNightModeProcessor$1
  implements NightModeLogic.NightModeCallback
{
  QQSettingMeNightModeProcessor$1(QQSettingMeNightModeProcessor paramQQSettingMeNightModeProcessor) {}
  
  public void a(Bundle paramBundle)
  {
    this.a.g();
  }
  
  public void b(Bundle paramBundle)
  {
    int i = paramBundle.getInt("start_status");
    if (i == 1)
    {
      this.a.g();
      return;
    }
    if (i == 2)
    {
      this.a.g();
      return;
    }
    if (i == 3)
    {
      i = paramBundle.getInt("percent");
      this.a.b.setValue(Integer.valueOf(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeNightModeProcessor.1
 * JD-Core Version:    0.7.0.1
 */