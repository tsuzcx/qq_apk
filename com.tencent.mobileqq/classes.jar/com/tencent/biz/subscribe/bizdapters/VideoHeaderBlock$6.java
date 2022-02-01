package com.tencent.biz.subscribe.bizdapters;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.widget.itemtouchhelper.GestureDetectorCompat;

class VideoHeaderBlock$6
  implements View.OnTouchListener
{
  VideoHeaderBlock$6(VideoHeaderBlock paramVideoHeaderBlock) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      VideoHeaderBlock.a(this.a, 0);
    }
    if (VideoHeaderBlock.d(this.a) != null) {
      VideoHeaderBlock.d(this.a).onTouchEvent(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.VideoHeaderBlock.6
 * JD-Core Version:    0.7.0.1
 */