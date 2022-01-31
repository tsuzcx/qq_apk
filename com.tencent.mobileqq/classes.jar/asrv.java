import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.multicard.MultiCardCustomLayout;
import com.tencent.mobileqq.multicard.MultiCardFragment;

public class asrv
  implements ValueAnimator.AnimatorUpdateListener
{
  public asrv(MultiCardFragment paramMultiCardFragment, assf paramassf, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.getAnimatedFraction();
    if (this.jdField_a_of_type_Assf == null) {
      return;
    }
    float f2 = this.jdField_a_of_type_Float + (1.0F - this.jdField_a_of_type_Float) * f1;
    this.jdField_a_of_type_Assf.a.setScaleX(f2);
    this.jdField_a_of_type_Assf.a.setScaleY(f2);
    this.jdField_a_of_type_Assf.a.setTranslationX(0.0F);
    this.jdField_a_of_type_Assf.a.setTranslationY(this.b * (1.0F - f1));
    paramValueAnimator = this.jdField_a_of_type_Assf.a.getLayoutParams();
    float f3 = this.c;
    float f4 = this.d;
    paramValueAnimator.height = ((int)((f1 * (1.0F - this.d) + f4) / f2 * f3));
    this.jdField_a_of_type_Assf.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asrv
 * JD-Core Version:    0.7.0.1
 */