package com.tencent.mobileqq.activity;

import android.view.MotionEvent;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener;
import com.tencent.mobileqq.studymode.ModeChoiceViewContainer;

class QQSettingSettingActivity$18
  implements TopGestureLayout.InterceptTouchEventListener
{
  QQSettingSettingActivity$18(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  public void OnDispatchTouchEvent(MotionEvent paramMotionEvent) {}
  
  public boolean OnInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (QQSettingSettingActivity.j(this.a) != null) {
      return QQSettingSettingActivity.j(this.a).a(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity.18
 * JD-Core Version:    0.7.0.1
 */