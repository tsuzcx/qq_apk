import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class bbas
  implements ValueAnimator.AnimatorUpdateListener
{
  bbas(audw paramaudw) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    this.a.a(paramValueAnimator.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbas
 * JD-Core Version:    0.7.0.1
 */