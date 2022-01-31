import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout;

class beyd
  implements ValueAnimator.AnimatorUpdateListener
{
  beyd(beyb parambeyb, float paramFloat1, float paramFloat2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    float f1 = this.jdField_a_of_type_Float;
    float f2 = paramValueAnimator.floatValue();
    float f3 = this.b;
    float f4 = this.jdField_a_of_type_Float;
    this.jdField_a_of_type_Beyb.a.setAlpha(f2 * (f3 - f4) + f1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beyd
 * JD-Core Version:    0.7.0.1
 */