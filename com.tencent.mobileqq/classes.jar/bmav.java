import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.capture.view.QIMCircleProgress;

public class bmav
  implements ValueAnimator.AnimatorUpdateListener
{
  public bmav(QIMCircleProgress paramQIMCircleProgress) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.c = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmav
 * JD-Core Version:    0.7.0.1
 */