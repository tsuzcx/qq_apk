import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class avwv
  implements ValueAnimator.AnimatorUpdateListener
{
  avwv(avwn paramavwn, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F - f);
    this.jdField_a_of_type_AndroidViewView.setTranslationY(f * aekt.a(25.0F, avwn.a(this.jdField_a_of_type_Avwn)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avwv
 * JD-Core Version:    0.7.0.1
 */