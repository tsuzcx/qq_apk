package com.tencent.aelight.camera.ae.camera.ui.capture;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;

class VideoStoryCapturePart$1
  implements View.OnTouchListener
{
  VideoStoryCapturePart$1(VideoStoryCapturePart paramVideoStoryCapturePart) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((VideoStoryCapturePart.a(this.a) != null) && (VideoStoryCapturePart.b(this.a) != null)) {
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, false, VideoStoryCapturePart.b(this.a), VideoStoryCapturePart.a(this.a));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.capture.VideoStoryCapturePart.1
 * JD-Core Version:    0.7.0.1
 */