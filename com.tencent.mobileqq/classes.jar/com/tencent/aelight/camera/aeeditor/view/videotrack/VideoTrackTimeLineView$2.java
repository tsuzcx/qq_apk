package com.tencent.aelight.camera.aeeditor.view.videotrack;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class VideoTrackTimeLineView$2
  extends AnimatorListenerAdapter
{
  VideoTrackTimeLineView$2(VideoTrackTimeLineView paramVideoTrackTimeLineView, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    VideoTrackTimeLineView.b(this.b).removeView(this.a);
    VideoTrackTimeLineView.a(this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackTimeLineView.2
 * JD-Core Version:    0.7.0.1
 */