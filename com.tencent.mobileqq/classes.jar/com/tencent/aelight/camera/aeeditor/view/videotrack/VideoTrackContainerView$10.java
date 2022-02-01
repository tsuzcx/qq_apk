package com.tencent.aelight.camera.aeeditor.view.videotrack;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.aelight.camera.aeeditor.view.dragdrop.IDragView;
import com.tencent.aelight.camera.aeeditor.view.timebar.ScaleTimeBar;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.ScaleAdapter;

class VideoTrackContainerView$10
  implements ValueAnimator.AnimatorUpdateListener
{
  VideoTrackContainerView$10(VideoTrackContainerView paramVideoTrackContainerView, IDragView paramIDragView, int paramInt1, int paramInt2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    ((VideoTrackTimeLineView)this.a).c(i);
    VideoTrackContainerView.i(this.d).scrollTo(this.b + VideoTrackContainerView.g(this.d).c(-(this.c - i)), 0);
    paramValueAnimator = this.d;
    paramValueAnimator.scrollTo(this.b + VideoTrackContainerView.g(paramValueAnimator).c(-(this.c - i)), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackContainerView.10
 * JD-Core Version:    0.7.0.1
 */