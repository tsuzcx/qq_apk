package com.tencent.mobileqq.activity.recent.cur;

import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;

class DragTextView$1
  extends GestureDetector.SimpleOnGestureListener
{
  DragTextView$1(DragTextView paramDragTextView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (DragTextView.a(this.a) != null) {
      return DragTextView.a(this.a).onDoubleTap(paramMotionEvent);
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (DragTextView.a(this.a) != null) {
      DragTextView.a(this.a).onDoubleTap(paramMotionEvent);
    }
    super.onLongPress(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (DragTextView.a(this.a) != null) {
      DragTextView.a(this.a).onSingleTapConfirmed(paramMotionEvent);
    }
    ViewParent localViewParent = this.a.getParent();
    if (localViewParent != null) {
      ((ViewGroup)localViewParent).performClick();
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.cur.DragTextView.1
 * JD-Core Version:    0.7.0.1
 */