import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.capture.view.QIMCircleProgress;

public class anpl
  implements ValueAnimator.AnimatorUpdateListener
{
  public anpl(QIMCircleProgress paramQIMCircleProgress) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.c = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anpl
 * JD-Core Version:    0.7.0.1
 */