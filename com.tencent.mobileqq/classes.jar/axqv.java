import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class axqv
  implements ValueAnimator.AnimatorUpdateListener
{
  axqv(axqp paramaxqp) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (axqp.a(this.a) != null)
    {
      axqp.a(this.a).setAlpha(f);
      axqp.a(this.a).setTranslationY((1.0F - f) * AIOUtils.dp2px(25.0F, axqp.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axqv
 * JD-Core Version:    0.7.0.1
 */