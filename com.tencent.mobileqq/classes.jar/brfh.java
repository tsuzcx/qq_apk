import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.qq.im.story.view.AnimationQIMCircleProgress;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayout;

public class brfh
  extends AnimatorListenerAdapter
{
  public brfh(QIMCameraSegmentCaptureButtonLayout paramQIMCameraSegmentCaptureButtonLayout, boolean paramBoolean, float paramFloat) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.a.e();
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.a.a(this.jdField_a_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brfh
 * JD-Core Version:    0.7.0.1
 */