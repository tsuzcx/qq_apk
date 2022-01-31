import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.animation.AccelerateDecelerateInterpolator;

@TargetApi(11)
public class bmol
{
  public static ValueAnimator a(long paramLong, float paramFloat1, float paramFloat2, bmoo parambmoo)
  {
    return a(ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 }), parambmoo, paramLong);
  }
  
  private static ValueAnimator a(ValueAnimator paramValueAnimator, bmoo parambmoo, long paramLong)
  {
    paramValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    paramValueAnimator.addUpdateListener(new bmom(parambmoo));
    paramValueAnimator.addListener(new bmon(parambmoo, paramValueAnimator));
    paramValueAnimator.setDuration(paramLong);
    return paramValueAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmol
 * JD-Core Version:    0.7.0.1
 */