import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.widget.ImageView;

class aqho
  extends AnimatorListenerAdapter
{
  aqho(aqhk paramaqhk, aqhr paramaqhr, ObjectAnimator paramObjectAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Aqhr != null) {
      this.jdField_a_of_type_Aqhr.a.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqho
 * JD-Core Version:    0.7.0.1
 */