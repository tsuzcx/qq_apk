import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.widget.ParticipleView;

public class biqs
  implements ValueAnimator.AnimatorUpdateListener
{
  public biqs(ParticipleView paramParticipleView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ParticipleView.a(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biqs
 * JD-Core Version:    0.7.0.1
 */