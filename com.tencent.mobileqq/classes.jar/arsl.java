import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.listentogether.lyrics.FloatIconLayout;

public class arsl
  implements ValueAnimator.AnimatorUpdateListener
{
  public arsl(FloatIconLayout paramFloatIconLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.b.setRotation(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arsl
 * JD-Core Version:    0.7.0.1
 */