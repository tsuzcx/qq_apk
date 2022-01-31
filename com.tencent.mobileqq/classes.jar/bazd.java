import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;

public class bazd
  implements ValueAnimator.AnimatorUpdateListener
{
  public bazd(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.b.setAlpha(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bazd
 * JD-Core Version:    0.7.0.1
 */