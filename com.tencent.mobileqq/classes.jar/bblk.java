import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class bblk
  implements ValueAnimator.AnimatorUpdateListener
{
  bblk(bblh parambblh) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (bblh.a(this.a) != null)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      bblh.a(this.a).setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bblk
 * JD-Core Version:    0.7.0.1
 */