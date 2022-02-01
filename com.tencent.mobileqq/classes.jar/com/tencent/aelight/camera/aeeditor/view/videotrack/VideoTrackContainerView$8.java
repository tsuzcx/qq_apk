package com.tencent.aelight.camera.aeeditor.view.videotrack;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.aelight.camera.aeeditor.view.dragdrop.IDragView;
import com.tencent.aelight.camera.aeeditor.view.playtrack.view.PlayTrackExpandWidthView;
import com.tencent.aelight.camera.aeeditor.view.timebar.ScaleTimeBar;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.ScaleAdapter;

class VideoTrackContainerView$8
  implements ValueAnimator.AnimatorUpdateListener
{
  VideoTrackContainerView$8(VideoTrackContainerView paramVideoTrackContainerView, IDragView paramIDragView, int paramInt1, int paramInt2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    ((VideoTrackTimeLineView)this.a).b(i);
    i = this.b + VideoTrackContainerView.g(this.d).c(this.c - i);
    ((VideoTrackTimeLineView)this.a).getVideoThumbnailView().scrollTo(i, 0);
    VideoTrackContainerView.i(this.d).scrollTo(i, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackContainerView.8
 * JD-Core Version:    0.7.0.1
 */