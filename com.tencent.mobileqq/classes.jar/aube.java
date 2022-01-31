import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.medalwall.MedalGuideView;

public class aube
  implements ValueAnimator.AnimatorUpdateListener
{
  public aube(MedalGuideView paramMedalGuideView) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aube
 * JD-Core Version:    0.7.0.1
 */