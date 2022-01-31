import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.animation.AccelerateDecelerateInterpolator;

@TargetApi(11)
public class bkdb
{
  public static ValueAnimator a(long paramLong, float paramFloat1, float paramFloat2, bkde parambkde)
  {
    return a(ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 }), parambkde, paramLong);
  }
  
  private static ValueAnimator a(ValueAnimator paramValueAnimator, bkde parambkde, long paramLong)
  {
    paramValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    paramValueAnimator.addUpdateListener(new bkdc(parambkde));
    paramValueAnimator.addListener(new bkdd(parambkde, paramValueAnimator));
    paramValueAnimator.setDuration(paramLong);
    return paramValueAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkdb
 * JD-Core Version:    0.7.0.1
 */