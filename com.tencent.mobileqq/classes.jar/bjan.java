import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class bjan
  implements ValueAnimator.AnimatorUpdateListener
{
  bjan(bjak parambjak) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (bjak.a(this.a) != null)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      bjak.a(this.a).setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjan
 * JD-Core Version:    0.7.0.1
 */