import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;

class ayvy
  implements Animator.AnimatorListener
{
  ayvy(ayvw paramayvw, View paramView, long paramLong, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    ayvw.a = false;
    if (this.jdField_a_of_type_Long != 0L) {
      aywa.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    ayvw.a = false;
    if (this.jdField_a_of_type_Long != 0L) {
      aywa.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ayvw.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvy
 * JD-Core Version:    0.7.0.1
 */