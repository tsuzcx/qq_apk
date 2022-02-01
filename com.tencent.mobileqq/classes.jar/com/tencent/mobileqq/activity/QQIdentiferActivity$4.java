package com.tencent.mobileqq.activity;

import android.widget.TextView;
import com.tencent.mobileqq.richmedia.capture.util.SensorShower.OnGetValue;

class QQIdentiferActivity$4
  implements SensorShower.OnGetValue
{
  QQIdentiferActivity$4(QQIdentiferActivity paramQQIdentiferActivity) {}
  
  public void a(float paramFloat)
  {
    QQIdentiferActivity localQQIdentiferActivity;
    if (paramFloat < 0.0F)
    {
      localQQIdentiferActivity = this.a;
      localQQIdentiferActivity.showTitleTips(localQQIdentiferActivity.getString(2131694317));
      return;
    }
    if (paramFloat > 175.0F)
    {
      localQQIdentiferActivity = this.a;
      localQQIdentiferActivity.showTitleTips(localQQIdentiferActivity.getString(2131694316));
      return;
    }
    QQIdentiferActivity.access$400(this.a).setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferActivity.4
 * JD-Core Version:    0.7.0.1
 */