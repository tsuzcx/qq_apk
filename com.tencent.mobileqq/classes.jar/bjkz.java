import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.capture.view.QIMCircleProgress;

public class bjkz
  implements ValueAnimator.AnimatorUpdateListener
{
  public bjkz(QIMCircleProgress paramQIMCircleProgress) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.c = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjkz
 * JD-Core Version:    0.7.0.1
 */