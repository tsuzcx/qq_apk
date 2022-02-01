package com.tencent.mm.ui.widget.sortlist;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class DragSortController$1
  extends GestureDetector.SimpleOnGestureListener
{
  DragSortController$1(DragSortController paramDragSortController) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((DragSortController.a(this.a)) && (DragSortController.b(this.a)))
    {
      int i = DragSortController.c(this.a).getWidth() / 5;
      if (paramFloat1 > DragSortController.d(this.a))
      {
        if (DragSortController.e(this.a) > -i) {
          DragSortController.c(this.a).stopDragWithVelocity(true, paramFloat1);
        }
      }
      else if ((paramFloat1 < -DragSortController.d(this.a)) && (DragSortController.e(this.a) < i)) {
        DragSortController.c(this.a).stopDragWithVelocity(true, paramFloat1);
      }
      DragSortController.a(this.a, false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortController.1
 * JD-Core Version:    0.7.0.1
 */