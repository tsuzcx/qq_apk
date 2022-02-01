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
    FramesProcessor.a(this.a).forceFinished(true);
    return true;
  }
  
  public boolean onFling(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.a)
    {
      FramesProcessor.a(this.a).fling((int)FramesProcessor.a(this.a), 0, (int)-paramFloat1, 0, (int)FramesProcessor.b(this.a), (int)FramesProcessor.c(this.a), 0, 0);
      FramesProcessor.b(this.a);
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
      FramesProcessor.a(this.a);
      if (FramesProcessor.a(this.a) != null) {
        FramesProcessor.a(this.a).a(FramesProcessor.a(this.a), FramesProcessor.b(this.a));
      }
      if (FramesProcessor.a(this.a) != null) {
        FramesProcessor.a(this.a).invalidate();
      }
      if (FramesProcessor.a(this.a) != null) {
        FramesProcessor.a(this.a).a(FramesProcessor.a(this.a), -FramesProcessor.a(this.a), FramesProcessor.e(this.a) - FramesProcessor.a(this.a));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FramesProcessor.1
 * JD-Core Version:    0.7.0.1
 */