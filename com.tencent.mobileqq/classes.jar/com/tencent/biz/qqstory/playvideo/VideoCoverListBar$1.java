package com.tencent.biz.qqstory.playvideo;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;

class VideoCoverListBar$1
  implements View.OnTouchListener
{
  float jdField_a_of_type_Float = -1.0F;
  float b = -1.0F;
  
  VideoCoverListBar$1(VideoCoverListBar paramVideoCoverListBar, int paramInt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i != 1) && (i != 3)) {
        return false;
      }
      if (Math.abs(paramMotionEvent.getY() - this.b) > Math.min(this.jdField_a_of_type_Int, 40)) {
        StoryReportor.a("play_video", "slide_mini", 0, 0, new String[] { "2", "", "", VideoCoverListBar.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar) });
      }
      this.jdField_a_of_type_Float = -1.0F;
      this.b = -1.0F;
      return false;
    }
    this.jdField_a_of_type_Float = paramMotionEvent.getX();
    this.b = paramMotionEvent.getY();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.VideoCoverListBar.1
 * JD-Core Version:    0.7.0.1
 */