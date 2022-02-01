package com.tencent.mobileqq.activity.aio.avatardoubletap;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class TouchEventHandler$1
  implements View.OnTouchListener
{
  TouchEventHandler$1(TouchEventHandler paramTouchEventHandler) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = paramView.getTag(2131362377);
    if (!(paramView instanceof GestureDetector)) {
      return false;
    }
    paramView = (GestureDetector)paramView;
    paramView.setIsLongpressEnabled(true);
    paramView.onTouchEvent(paramMotionEvent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.avatardoubletap.TouchEventHandler.1
 * JD-Core Version:    0.7.0.1
 */