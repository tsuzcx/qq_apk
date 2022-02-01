import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.multicard.MultiCardCustomLayout;
import com.tencent.mobileqq.multicard.MultiCardFragment;

public class awaf
  implements ValueAnimator.AnimatorUpdateListener
{
  public awaf(MultiCardFragment paramMultiCardFragment, awar paramawar, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.getAnimatedFraction();
    if (this.jdField_a_of_type_Awar == null) {
      return;
    }
    float f2 = 1.0F - (1.0F - this.jdField_a_of_type_Float) * f1;
    this.jdField_a_of_type_Awar.a.setScaleX(f2);
    this.jdField_a_of_type_Awar.a.setScaleY(f2);
    this.jdField_a_of_type_Awar.a.setTranslationX(0.0F);
    this.jdField_a_of_type_Awar.a.setTranslationY(this.b * f1);
    paramValueAnimator = this.jdField_a_of_type_Awar.a.getLayoutParams();
    float f3 = this.c;
    paramValueAnimator.height = ((int)((1.0F - f1 * (1.0F - this.d)) / f2 * f3));
    this.jdField_a_of_type_Awar.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awaf
 * JD-Core Version:    0.7.0.1
 */