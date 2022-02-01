import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.widget.ImageView;

class aqkz
  extends AnimatorListenerAdapter
{
  aqkz(aqkv paramaqkv, aqlc paramaqlc, ObjectAnimator paramObjectAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Aqlc != null) {
      this.jdField_a_of_type_Aqlc.a.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqkz
 * JD-Core Version:    0.7.0.1
 */