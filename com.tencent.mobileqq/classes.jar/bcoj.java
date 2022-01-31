import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.widget.ParticipleView;

public class bcoj
  implements ValueAnimator.AnimatorUpdateListener
{
  public bcoj(ParticipleView paramParticipleView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ParticipleView.a(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcoj
 * JD-Core Version:    0.7.0.1
 */