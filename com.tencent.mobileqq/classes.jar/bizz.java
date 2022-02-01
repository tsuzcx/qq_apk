import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.widget.ParticipleView;

public class bizz
  implements ValueAnimator.AnimatorUpdateListener
{
  public bizz(ParticipleView paramParticipleView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ParticipleView.a(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bizz
 * JD-Core Version:    0.7.0.1
 */