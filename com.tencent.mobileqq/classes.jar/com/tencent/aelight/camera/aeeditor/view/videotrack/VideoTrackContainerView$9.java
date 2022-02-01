package com.tencent.aelight.camera.aeeditor.view.videotrack;

import android.animation.Animator;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.aelight.camera.aeeditor.view.dragdrop.IDragView;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import java.util.List;

class VideoTrackContainerView$9
  extends D8SafeAnimatorListener
{
  VideoTrackContainerView$9(VideoTrackContainerView paramVideoTrackContainerView, IDragView paramIDragView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    VideoTrackContainerView.a(this.b, false);
    VideoTrackContainerView.b(this.b, false);
    VideoTrackContainerView.a(this.b, null);
    paramAnimator = this.b;
    VideoTrackContainerView.b(paramAnimator, ((ViewGroup.MarginLayoutParams)((VideoTrackTimeLineView)VideoTrackContainerView.j(paramAnimator).get(0)).getLayoutParams()).leftMargin);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    VideoTrackContainerView.a(this.b, false);
    VideoTrackContainerView.b(this.b, false);
    VideoTrackContainerView.a(this.b, null);
    this.a.a();
    paramAnimator = this.b;
    VideoTrackContainerView.b(paramAnimator, ((ViewGroup.MarginLayoutParams)((VideoTrackTimeLineView)VideoTrackContainerView.j(paramAnimator).get(0)).getLayoutParams()).leftMargin);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackContainerView.9
 * JD-Core Version:    0.7.0.1
 */