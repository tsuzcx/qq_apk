import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.medalwall.MedalGuideView;

public class awim
  implements ValueAnimator.AnimatorUpdateListener
{
  public awim(MedalGuideView paramMedalGuideView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue("alpha")).floatValue();
    MedalGuideView.a(this.a, f);
    int i = ((Integer)this.a.jdField_a_of_type_AndroidAnimationArgbEvaluator.evaluate(f, Integer.valueOf(0), Integer.valueOf(this.a.jdField_a_of_type_Int))).intValue();
    this.a.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(i);
    if (paramValueAnimator.getAnimatedFraction() >= 1.0F) {
      paramValueAnimator.removeAllUpdateListeners();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awim
 * JD-Core Version:    0.7.0.1
 */