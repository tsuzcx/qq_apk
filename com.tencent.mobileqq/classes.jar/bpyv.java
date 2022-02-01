import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ptv.BaseButton;
import dov.com.qq.im.ptv.LightWeightCaptureButtonCornerLayout;

public class bpyv
  extends AnimatorListenerAdapter
{
  public bpyv(LightWeightCaptureButtonCornerLayout paramLightWeightCaptureButtonCornerLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "rollBackDeleteAnimatorToActiveCorner captureView 190ms all end ScaleX:" + this.a.jdField_a_of_type_DovComQqImPtvBaseButton.getScaleX() + " ScaleY:" + this.a.jdField_a_of_type_DovComQqImPtvBaseButton.getScaleY());
    }
    this.a.jdField_a_of_type_Bpzp.d = 1;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "rollBackDeleteAnimatorToActiveCorner captureView begin  ScaleX:" + this.a.jdField_a_of_type_DovComQqImPtvBaseButton.getScaleX() + " ScaleY:" + this.a.jdField_a_of_type_DovComQqImPtvBaseButton.getScaleY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpyv
 * JD-Core Version:    0.7.0.1
 */