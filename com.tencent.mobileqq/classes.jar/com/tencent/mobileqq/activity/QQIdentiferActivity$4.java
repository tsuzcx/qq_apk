package com.tencent.mobileqq.activity;

import android.widget.TextView;
import com.tencent.mobileqq.richmedia.capture.util.SensorShower.OnGetValue;

class QQIdentiferActivity$4
  implements SensorShower.OnGetValue
{
  QQIdentiferActivity$4(QQIdentiferActivity paramQQIdentiferActivity) {}
  
  public void a(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      this.a.a(this.a.getString(2131694352));
      return;
    }
    if (paramFloat > 175.0F)
    {
      this.a.a(this.a.getString(2131694351));
      return;
    }
    QQIdentiferActivity.a(this.a).setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferActivity.4
 * JD-Core Version:    0.7.0.1
 */