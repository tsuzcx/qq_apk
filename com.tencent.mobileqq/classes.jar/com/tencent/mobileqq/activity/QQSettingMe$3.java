package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class QQSettingMe$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  QQSettingMe$3(QQSettingMe paramQQSettingMe) {}
  
  public void onGlobalLayout()
  {
    if (QQSettingMe.a(this.a)) {
      QQSettingMe.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.3
 * JD-Core Version:    0.7.0.1
 */