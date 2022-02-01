package com.tencent.mobileqq.activity;

import android.view.MotionEvent;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener;
import com.tencent.mobileqq.studymode.ModeChoiceViewContainer;

class GeneralSettingActivity$11
  implements TopGestureLayout.InterceptTouchEventListener
{
  GeneralSettingActivity$11(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void OnDispatchTouchEvent(MotionEvent paramMotionEvent) {}
  
  public boolean OnInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (GeneralSettingActivity.a(this.a) != null) {
      return GeneralSettingActivity.a(this.a).a(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.11
 * JD-Core Version:    0.7.0.1
 */