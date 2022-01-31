import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;

public class bs
  implements ValueAnimator.AnimatorUpdateListener
{
  public bs(LiteActivity paramLiteActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    LiteActivity.a(this.a).getLayoutParams().height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    LiteActivity.a(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bs
 * JD-Core Version:    0.7.0.1
 */