import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.multicard.MultiCardCustomLayout;
import com.tencent.mobileqq.multicard.MultiCardFragment;

public class aunb
  implements ValueAnimator.AnimatorUpdateListener
{
  public aunb(MultiCardFragment paramMultiCardFragment, aunn paramaunn, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.getAnimatedFraction();
    if (this.jdField_a_of_type_Aunn == null) {
      return;
    }
    float f2 = 1.0F - (1.0F - this.jdField_a_of_type_Float) * f1;
    this.jdField_a_of_type_Aunn.a.setScaleX(f2);
    this.jdField_a_of_type_Aunn.a.setScaleY(f2);
    this.jdField_a_of_type_Aunn.a.setTranslationX(0.0F);
    this.jdField_a_of_type_Aunn.a.setTranslationY(this.b * f1);
    paramValueAnimator = this.jdField_a_of_type_Aunn.a.getLayoutParams();
    float f3 = this.c;
    paramValueAnimator.height = ((int)((1.0F - f1 * (1.0F - this.d)) / f2 * f3));
    this.jdField_a_of_type_Aunn.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aunb
 * JD-Core Version:    0.7.0.1
 */