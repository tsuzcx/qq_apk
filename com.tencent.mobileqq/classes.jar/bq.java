import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.dataline.activities.LiteActivity;
import com.tencent.widget.XEditTextEx;

public class bq
  implements ValueAnimator.AnimatorUpdateListener
{
  public bq(LiteActivity paramLiteActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.a.getLayoutParams().height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bq
 * JD-Core Version:    0.7.0.1
 */