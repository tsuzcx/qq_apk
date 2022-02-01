package com.tencent.mobileqq.activity;

import android.view.MotionEvent;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener;

class GeneralSettingActivity$15
  implements TopGestureLayout.InterceptTouchEventListener
{
  GeneralSettingActivity$15(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void OnDispatchTouchEvent(MotionEvent paramMotionEvent) {}
  
  public boolean OnInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a.a != null) {
      return this.a.a.a(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.15
 * JD-Core Version:    0.7.0.1
 */