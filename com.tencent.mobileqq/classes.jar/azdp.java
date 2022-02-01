import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class azdp
  implements ValueAnimator.AnimatorUpdateListener
{
  azdp(azdh paramazdh, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F - f);
    this.jdField_a_of_type_AndroidViewView.setTranslationY(f * agej.a(25.0F, azdh.a(this.jdField_a_of_type_Azdh)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdp
 * JD-Core Version:    0.7.0.1
 */