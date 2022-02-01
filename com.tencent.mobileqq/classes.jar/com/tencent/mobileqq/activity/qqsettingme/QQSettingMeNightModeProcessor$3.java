package com.tencent.mobileqq.activity.qqsettingme;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.activity.QQSettingMe;

class QQSettingMeNightModeProcessor$3
  implements Observer<Integer>
{
  QQSettingMeNightModeProcessor$3(QQSettingMeNightModeProcessor paramQQSettingMeNightModeProcessor, QQSettingMe paramQQSettingMe) {}
  
  public void a(Integer paramInteger)
  {
    if (paramInteger.intValue() == 0) {
      return;
    }
    this.a.b(paramInteger.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeNightModeProcessor.3
 * JD-Core Version:    0.7.0.1
 */