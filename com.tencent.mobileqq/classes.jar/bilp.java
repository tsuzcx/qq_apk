import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.animation.AccelerateDecelerateInterpolator;

@TargetApi(11)
public class bilp
{
  public static ValueAnimator a(long paramLong, float paramFloat1, float paramFloat2, bils parambils)
  {
    return a(ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 }), parambils, paramLong);
  }
  
  private static ValueAnimator a(ValueAnimator paramValueAnimator, bils parambils, long paramLong)
  {
    paramValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    paramValueAnimator.addUpdateListener(new bilq(parambils));
    paramValueAnimator.addListener(new bilr(parambils, paramValueAnimator));
    paramValueAnimator.setDuration(paramLong);
    return paramValueAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bilp
 * JD-Core Version:    0.7.0.1
 */