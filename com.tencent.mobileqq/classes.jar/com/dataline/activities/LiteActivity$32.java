package com.dataline.activities;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class LiteActivity$32
  implements View.OnTouchListener
{
  LiteActivity$32(LiteActivity paramLiteActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      LiteActivity.f(this.a).x = paramMotionEvent.getRawX();
      LiteActivity.f(this.a).y = paramMotionEvent.getRawY();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.32
 * JD-Core Version:    0.7.0.1
 */