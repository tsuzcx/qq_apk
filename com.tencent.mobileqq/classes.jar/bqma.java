import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;

final class bqma
  implements Animator.AnimatorListener
{
  bqma(bqmb parambqmb, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Bqmb != null) {
      this.jdField_a_of_type_Bqmb.d(this.jdField_a_of_type_AndroidAnimationValueAnimator);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Bqmb != null) {
      this.jdField_a_of_type_Bqmb.c(this.jdField_a_of_type_AndroidAnimationValueAnimator);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Bqmb != null) {
      this.jdField_a_of_type_Bqmb.b(this.jdField_a_of_type_AndroidAnimationValueAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqma
 * JD-Core Version:    0.7.0.1
 */