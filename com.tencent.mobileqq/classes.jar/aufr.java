import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class aufr
  implements ValueAnimator.AnimatorUpdateListener
{
  aufr(aufj paramaufj, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F - f);
    this.jdField_a_of_type_AndroidViewView.setTranslationY(f * actj.a(25.0F, aufj.a(this.jdField_a_of_type_Aufj)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aufr
 * JD-Core Version:    0.7.0.1
 */