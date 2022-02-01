package com.tencent.aelight.camera.aeeditor.view.videotrack;

import android.animation.Animator;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.aelight.camera.aeeditor.view.dragdrop.IDragView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import java.util.List;

class VideoTrackContainerView$11
  extends D8SafeAnimatorListener
{
  VideoTrackContainerView$11(VideoTrackContainerView paramVideoTrackContainerView, IDragView paramIDragView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AEQLog.b("miles", "动画取消");
    VideoTrackContainerView.a(this.b, false);
    VideoTrackContainerView.b(this.b, false);
    VideoTrackContainerView.a(this.b, null);
    paramAnimator = this.b;
    VideoTrackContainerView.c(paramAnimator, ((ViewGroup.MarginLayoutParams)((VideoTrackTimeLineView)VideoTrackContainerView.j(paramAnimator).get(VideoTrackContainerView.j(this.b).size() - 1)).getLayoutParams()).rightMargin);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEQLog.b("miles", "动画结束");
    VideoTrackContainerView.a(this.b, false);
    VideoTrackContainerView.b(this.b, false);
    VideoTrackContainerView.a(this.b, null);
    this.a.a();
    paramAnimator = this.b;
    VideoTrackContainerView.c(paramAnimator, ((ViewGroup.MarginLayoutParams)((VideoTrackTimeLineView)VideoTrackContainerView.j(paramAnimator).get(VideoTrackContainerView.j(this.b).size() - 1)).getLayoutParams()).rightMargin);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackContainerView.11
 * JD-Core Version:    0.7.0.1
 */