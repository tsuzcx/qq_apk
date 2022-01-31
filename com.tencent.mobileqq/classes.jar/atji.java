import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.listentogether.lyrics.FloatIconLayout;

public class atji
  implements ValueAnimator.AnimatorUpdateListener
{
  public atji(FloatIconLayout paramFloatIconLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.b.setRotation(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atji
 * JD-Core Version:    0.7.0.1
 */