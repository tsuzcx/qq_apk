import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.widget.SlideDownFrameLayout;

public class bits
  implements ValueAnimator.AnimatorUpdateListener
{
  public bits(SlideDownFrameLayout paramSlideDownFrameLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    SlideDownFrameLayout.a(this.a).a().setY(f);
    SlideDownFrameLayout.a(this.a).a(f, SlideDownFrameLayout.a(this.a).a().getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bits
 * JD-Core Version:    0.7.0.1
 */