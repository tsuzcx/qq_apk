import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.troop.widget.RedDotAnimateView;

public class baon
  implements ValueAnimator.AnimatorUpdateListener
{
  public baon(RedDotAnimateView paramRedDotAnimateView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.jdField_a_of_type_Float = (((Float)paramValueAnimator.getAnimatedValue()).floatValue() * this.a.jdField_a_of_type_Int / 2.0F);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baon
 * JD-Core Version:    0.7.0.1
 */