import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.capture.view.QIMCircleProgress;

public class anpn
  implements ValueAnimator.AnimatorUpdateListener
{
  public anpn(QIMCircleProgress paramQIMCircleProgress) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.c = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anpn
 * JD-Core Version:    0.7.0.1
 */