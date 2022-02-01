import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;

class baat
  implements Animator.AnimatorListener
{
  baat(baar parambaar, View paramView, long paramLong, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    baar.a = false;
    if (this.jdField_a_of_type_Long != 0L) {
      baav.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    baar.a = false;
    if (this.jdField_a_of_type_Long != 0L) {
      baav.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    baar.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baat
 * JD-Core Version:    0.7.0.1
 */