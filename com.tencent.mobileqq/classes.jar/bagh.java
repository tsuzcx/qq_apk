import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;

class bagh
  implements Animator.AnimatorListener
{
  bagh(bagf parambagf, View paramView, long paramLong, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    bagf.a = false;
    if (this.jdField_a_of_type_Long != 0L) {
      bagj.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    bagf.a = false;
    if (this.jdField_a_of_type_Long != 0L) {
      bagj.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    bagf.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagh
 * JD-Core Version:    0.7.0.1
 */