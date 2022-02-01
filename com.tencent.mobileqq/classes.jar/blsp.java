import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class blsp
  implements ValueAnimator.AnimatorUpdateListener
{
  blsp(blso paramblso, blsg paramblsg) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Blso.a(paramValueAnimator.getAnimatedFraction());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blsp
 * JD-Core Version:    0.7.0.1
 */