import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.dataline.activities.LiteActivity;
import com.tencent.widget.XEditTextEx;

public class bp
  implements ValueAnimator.AnimatorUpdateListener
{
  public bp(LiteActivity paramLiteActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.a.getLayoutParams().height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bp
 * JD-Core Version:    0.7.0.1
 */