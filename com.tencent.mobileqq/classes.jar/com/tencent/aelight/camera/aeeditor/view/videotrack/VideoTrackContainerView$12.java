package com.tencent.aelight.camera.aeeditor.view.videotrack;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.aelight.camera.aeeditor.view.dragdrop.IDragView;
import com.tencent.aelight.camera.aeeditor.view.timebar.ScaleTimeBar;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.ScaleAdapter;

class VideoTrackContainerView$12
  implements ValueAnimator.AnimatorUpdateListener
{
  VideoTrackContainerView$12(VideoTrackContainerView paramVideoTrackContainerView, IDragView paramIDragView, int paramInt1, int paramInt2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    ((VideoTrackTimeLineView)this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIDragView).d(i);
    VideoTrackContainerView.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView).scrollTo(this.jdField_a_of_type_Int + VideoTrackContainerView.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView).a(this.b - i), 0);
    paramValueAnimator = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView;
    paramValueAnimator.scrollTo(this.jdField_a_of_type_Int + VideoTrackContainerView.a(paramValueAnimator).a(this.b - i), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackContainerView.12
 * JD-Core Version:    0.7.0.1
 */