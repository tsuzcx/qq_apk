import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;

public class azbf
  implements ValueAnimator.AnimatorUpdateListener
{
  public azbf(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.b.setAlpha(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azbf
 * JD-Core Version:    0.7.0.1
 */