package com.tencent.biz.subscribe.bizdapters;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;

class VideoHeaderBlock$ItemTouchHelperGestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  private VideoHeaderBlock$ItemTouchHelperGestureListener(VideoHeaderBlock paramVideoHeaderBlock) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    float f1 = paramMotionEvent2.getY() - VideoHeaderBlock.a(this.a);
    if (VideoHeaderBlock.b(this.a) < VideoHeaderBlock.c(this.a)) {
      return false;
    }
    if ((f1 > 0.0F) && (VideoHeaderBlock.d(this.a) < VideoHeaderBlock.e(this.a)))
    {
      f2 = VideoHeaderBlock.d(this.a);
      f1 = Math.abs(f1) + f2;
      localVideoHeaderBlock = this.a;
      if (f1 > VideoHeaderBlock.e(this.a))
      {
        i = VideoHeaderBlock.e(this.a);
        VideoHeaderBlock.b(localVideoHeaderBlock, i);
      }
    }
    while ((f1 >= 0.0F) || (VideoHeaderBlock.d(this.a) <= VideoHeaderBlock.f(this.a))) {
      for (;;)
      {
        float f2;
        if (VideoHeaderBlock.a(this.a) != null)
        {
          VideoHeaderBlock.a(this.a).getLayoutParams().height = VideoHeaderBlock.d(this.a);
          VideoHeaderBlock.a(this.a).requestLayout();
        }
        return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        i = (int)f1;
      }
    }
    f1 = VideoHeaderBlock.d(this.a) - Math.abs(f1);
    VideoHeaderBlock localVideoHeaderBlock = this.a;
    if (f1 < VideoHeaderBlock.f(this.a)) {}
    for (int i = VideoHeaderBlock.f(this.a);; i = (int)f1)
    {
      VideoHeaderBlock.b(localVideoHeaderBlock, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.VideoHeaderBlock.ItemTouchHelperGestureListener
 * JD-Core Version:    0.7.0.1
 */