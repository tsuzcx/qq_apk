import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.medalwall.MedalGuideView;

public class avon
  implements ValueAnimator.AnimatorUpdateListener
{
  public avon(MedalGuideView paramMedalGuideView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = ((Integer)this.a.jdField_a_of_type_AndroidAnimationArgbEvaluator.evaluate(f, Integer.valueOf(this.a.jdField_a_of_type_Int), Integer.valueOf(0))).intValue();
    this.a.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(i);
    if (paramValueAnimator.getAnimatedFraction() >= 1.0F) {
      paramValueAnimator.removeAllUpdateListeners();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avon
 * JD-Core Version:    0.7.0.1
 */