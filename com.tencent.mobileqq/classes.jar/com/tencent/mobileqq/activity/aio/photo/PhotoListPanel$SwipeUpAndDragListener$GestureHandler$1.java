package com.tencent.mobileqq.activity.aio.photo;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;

class PhotoListPanel$SwipeUpAndDragListener$GestureHandler$1
  implements View.OnTouchListener
{
  PhotoListPanel$SwipeUpAndDragListener$GestureHandler$1(PhotoListPanel.SwipeUpAndDragListener.GestureHandler paramGestureHandler, PhotoListPanel.SwipeUpAndDragListener paramSwipeUpAndDragListener) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = paramView.getParent();
    if (paramView != null) {
      paramView.requestDisallowInterceptTouchEvent(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener.GestureHandler.1
 * JD-Core Version:    0.7.0.1
 */