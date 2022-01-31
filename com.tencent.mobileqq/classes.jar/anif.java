import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.animation.AnimatorFactory.AnimatorListener;

public final class anif
  implements Animator.AnimatorListener
{
  public anif(AnimatorFactory.AnimatorListener paramAnimatorListener, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationAnimatorFactory$AnimatorListener != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationAnimatorFactory$AnimatorListener.d(this.jdField_a_of_type_AndroidAnimationValueAnimator);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationAnimatorFactory$AnimatorListener != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationAnimatorFactory$AnimatorListener.c(this.jdField_a_of_type_AndroidAnimationValueAnimator);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationAnimatorFactory$AnimatorListener != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationAnimatorFactory$AnimatorListener.b(this.jdField_a_of_type_AndroidAnimationValueAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anif
 * JD-Core Version:    0.7.0.1
 */