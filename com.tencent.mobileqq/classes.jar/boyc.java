import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.animation.AccelerateDecelerateInterpolator;

@TargetApi(11)
public class boyc
{
  public static ValueAnimator a(long paramLong, float paramFloat1, float paramFloat2, boyf paramboyf)
  {
    return a(ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 }), paramboyf, paramLong);
  }
  
  private static ValueAnimator a(ValueAnimator paramValueAnimator, boyf paramboyf, long paramLong)
  {
    paramValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    paramValueAnimator.addUpdateListener(new boyd(paramboyf));
    paramValueAnimator.addListener(new boye(paramboyf, paramValueAnimator));
    paramValueAnimator.setDuration(paramLong);
    return paramValueAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boyc
 * JD-Core Version:    0.7.0.1
 */