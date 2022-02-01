package com.tencent.biz.subscribe.bizdapters;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.MotionEvent;
import com.tencent.widget.itemtouchhelper.GestureDetectorCompat;

class VideoHeaderBlock$5
  implements RecyclerView.OnItemTouchListener
{
  VideoHeaderBlock$5(VideoHeaderBlock paramVideoHeaderBlock) {}
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    return VideoHeaderBlock.a(this.a, paramMotionEvent);
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    if (VideoHeaderBlock.a(this.a) != null) {
      VideoHeaderBlock.a(this.a).onTouchEvent(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.VideoHeaderBlock.5
 * JD-Core Version:    0.7.0.1
 */