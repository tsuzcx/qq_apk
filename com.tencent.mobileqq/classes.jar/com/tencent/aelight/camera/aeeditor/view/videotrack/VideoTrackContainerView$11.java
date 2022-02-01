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
    VideoTrackContainerView.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView, false);
    VideoTrackContainerView.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView, false);
    VideoTrackContainerView.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView, null);
    paramAnimator = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView;
    VideoTrackContainerView.c(paramAnimator, ((ViewGroup.MarginLayoutParams)((VideoTrackTimeLineView)VideoTrackContainerView.a(paramAnimator).get(VideoTrackContainerView.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView).size() - 1)).getLayoutParams()).rightMargin);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEQLog.b("miles", "动画结束");
    VideoTrackContainerView.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView, false);
    VideoTrackContainerView.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView, false);
    VideoTrackContainerView.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView, null);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIDragView.a();
    paramAnimator = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView;
    VideoTrackContainerView.c(paramAnimator, ((ViewGroup.MarginLayoutParams)((VideoTrackTimeLineView)VideoTrackContainerView.a(paramAnimator).get(VideoTrackContainerView.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView).size() - 1)).getLayoutParams()).rightMargin);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackContainerView.11
 * JD-Core Version:    0.7.0.1
 */