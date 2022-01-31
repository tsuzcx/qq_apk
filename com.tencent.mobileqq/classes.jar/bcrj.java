import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.troop.widget.RedDotAnimateView;

public class bcrj
  implements ValueAnimator.AnimatorUpdateListener
{
  public bcrj(RedDotAnimateView paramRedDotAnimateView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.jdField_a_of_type_Float = (((Float)paramValueAnimator.getAnimatedValue()).floatValue() * this.a.jdField_a_of_type_Int / 2.0F);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcrj
 * JD-Core Version:    0.7.0.1
 */