package com.tencent.mobileqq.activity.selectable;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class CommonSelectableMenu$1
  implements View.OnTouchListener
{
  CommonSelectableMenu$1(CommonSelectableMenu paramCommonSelectableMenu) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      CommonSelectableMenu.a(this.a).x = ((int)paramMotionEvent.getRawX());
      CommonSelectableMenu.a(this.a).y = ((int)paramMotionEvent.getRawY());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.CommonSelectableMenu.1
 * JD-Core Version:    0.7.0.1
 */