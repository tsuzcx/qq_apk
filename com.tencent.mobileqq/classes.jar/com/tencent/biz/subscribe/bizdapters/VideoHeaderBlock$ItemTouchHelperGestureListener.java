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
    float f = paramMotionEvent2.getY() - VideoHeaderBlock.a(this.a);
    if (VideoHeaderBlock.b(this.a) < VideoHeaderBlock.c(this.a)) {
      return false;
    }
    VideoHeaderBlock localVideoHeaderBlock;
    int i;
    if ((f > 0.0F) && (VideoHeaderBlock.d(this.a) < VideoHeaderBlock.e(this.a)))
    {
      f = VideoHeaderBlock.d(this.a) + Math.abs(f);
      localVideoHeaderBlock = this.a;
      if (f > VideoHeaderBlock.e(localVideoHeaderBlock)) {
        i = VideoHeaderBlock.e(this.a);
      } else {
        i = (int)f;
      }
      VideoHeaderBlock.b(localVideoHeaderBlock, i);
    }
    else if ((f < 0.0F) && (VideoHeaderBlock.d(this.a) > VideoHeaderBlock.f(this.a)))
    {
      f = VideoHeaderBlock.d(this.a) - Math.abs(f);
      localVideoHeaderBlock = this.a;
      if (f < VideoHeaderBlock.f(localVideoHeaderBlock)) {
        i = VideoHeaderBlock.f(this.a);
      } else {
        i = (int)f;
      }
      VideoHeaderBlock.b(localVideoHeaderBlock, i);
    }
    if (VideoHeaderBlock.a(this.a) != null)
    {
      VideoHeaderBlock.a(this.a).getLayoutParams().height = VideoHeaderBlock.d(this.a);
      VideoHeaderBlock.a(this.a).requestLayout();
    }
    return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.VideoHeaderBlock.ItemTouchHelperGestureListener
 * JD-Core Version:    0.7.0.1
 */