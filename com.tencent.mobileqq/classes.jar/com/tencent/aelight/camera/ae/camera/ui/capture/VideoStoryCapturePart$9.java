package com.tencent.aelight.camera.ae.camera.ui.capture;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

class VideoStoryCapturePart$9
  extends ViewOutlineProvider
{
  VideoStoryCapturePart$9(VideoStoryCapturePart paramVideoStoryCapturePart, float paramFloat) {}
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    paramOutline.setRoundRect(new Rect(0, 0, localRect.right - localRect.left - 0, localRect.bottom - localRect.top - 0), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.capture.VideoStoryCapturePart.9
 * JD-Core Version:    0.7.0.1
 */