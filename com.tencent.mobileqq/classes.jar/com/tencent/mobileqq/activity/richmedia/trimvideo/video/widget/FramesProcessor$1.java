package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;

class FramesProcessor$1
  implements GestureDetector.OnGestureListener
{
  FramesProcessor$1(FramesProcessor paramFramesProcessor) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    FramesProcessor.l(this.a).forceFinished(true);
    return true;
  }
  
  public boolean onFling(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.a)
    {
      FramesProcessor.l(this.a).fling((int)FramesProcessor.a(this.a), 0, (int)-paramFloat1, 0, (int)FramesProcessor.b(this.a), (int)FramesProcessor.c(this.a), 0, 0);
      FramesProcessor.m(this.a);
      return true;
    }
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.a)
    {
      FramesProcessor.a(this.a, FramesProcessor.a(this.a) + paramFloat1);
      if (FramesProcessor.a(this.a) < FramesProcessor.b(this.a))
      {
        ??? = this.a;
        FramesProcessor.a(???, FramesProcessor.b(???));
      }
      if (FramesProcessor.a(this.a) > FramesProcessor.c(this.a))
      {
        ??? = this.a;
        FramesProcessor.a(???, FramesProcessor.c(???));
      }
      paramFloat1 = FramesProcessor.a(this.a);
      paramFloat2 = FramesProcessor.d(this.a);
      ??? = this.a;
      FramesProcessor.b(???, FramesProcessor.a(???));
      if (FramesProcessor.a(this.a, paramFloat1 - paramFloat2, 0.0F)) {
        return true;
      }
      FramesProcessor.e(this.a);
      if (FramesProcessor.f(this.a) != null) {
        FramesProcessor.f(this.a).a(FramesProcessor.g(this.a), FramesProcessor.h(this.a));
      }
      if (FramesProcessor.i(this.a) != null) {
        FramesProcessor.i(this.a).invalidate();
      }
      if (FramesProcessor.j(this.a) != null) {
        FramesProcessor.j(this.a).a(FramesProcessor.a(this.a), -FramesProcessor.a(this.a), FramesProcessor.k(this.a) - FramesProcessor.a(this.a));
      }
      return true;
    }
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FramesProcessor.1
 * JD-Core Version:    0.7.0.1
 */