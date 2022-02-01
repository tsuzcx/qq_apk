import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.widget.DynamicGridView;

public class blkp
  implements ValueAnimator.AnimatorUpdateListener
{
  public blkp(DynamicGridView paramDynamicGridView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blkp
 * JD-Core Version:    0.7.0.1
 */