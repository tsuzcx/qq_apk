import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.graphics.Paint;
import dov.com.qq.im.ae.view.AECMShowFaceScanView;

public class bnrm
  implements Animator.AnimatorListener
{
  public bnrm(AECMShowFaceScanView paramAECMShowFaceScanView, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AECMShowFaceScanView.a(this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView, false);
    this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
    this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView.d.setAlpha(255);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AECMShowFaceScanView.a(this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView, true);
    if (this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView.jdField_a_of_type_Bnrq != null) {
      this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView.jdField_a_of_type_Bnrq.G();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnrm
 * JD-Core Version:    0.7.0.1
 */