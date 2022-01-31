import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class bhzt
  implements ValueAnimator.AnimatorUpdateListener
{
  bhzt(bhzs parambhzs, bhzk parambhzk) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Bhzs.a(paramValueAnimator.getAnimatedFraction());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhzt
 * JD-Core Version:    0.7.0.1
 */