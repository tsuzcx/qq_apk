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
    float f = paramMotionEvent2.getY() - VideoHeaderBlock.e(this.a);
    if (VideoHeaderBlock.f(this.a) < VideoHeaderBlock.g(this.a)) {
      return false;
    }
    VideoHeaderBlock localVideoHeaderBlock;
    int i;
    if ((f > 0.0F) && (VideoHeaderBlock.h(this.a) < VideoHeaderBlock.i(this.a)))
    {
      f = VideoHeaderBlock.h(this.a) + Math.abs(f);
      localVideoHeaderBlock = this.a;
      if (f > VideoHeaderBlock.i(localVideoHeaderBlock)) {
        i = VideoHeaderBlock.i(this.a);
      } else {
        i = (int)f;
      }
      VideoHeaderBlock.b(localVideoHeaderBlock, i);
    }
    else if ((f < 0.0F) && (VideoHeaderBlock.h(this.a) > VideoHeaderBlock.j(this.a)))
    {
      f = VideoHeaderBlock.h(this.a) - Math.abs(f);
      localVideoHeaderBlock = this.a;
      if (f < VideoHeaderBlock.j(localVideoHeaderBlock)) {
        i = VideoHeaderBlock.j(this.a);
      } else {
        i = (int)f;
      }
      VideoHeaderBlock.b(localVideoHeaderBlock, i);
    }
    if (VideoHeaderBlock.a(this.a) != null)
    {
      VideoHeaderBlock.a(this.a).getLayoutParams().height = VideoHeaderBlock.h(this.a);
      VideoHeaderBlock.a(this.a).requestLayout();
    }
    return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.VideoHeaderBlock.ItemTouchHelperGestureListener
 * JD-Core Version:    0.7.0.1
 */