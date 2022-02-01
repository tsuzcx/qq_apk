import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.animation.AccelerateDecelerateInterpolator;

@TargetApi(11)
public class bnik
{
  public static ValueAnimator a(long paramLong, float paramFloat1, float paramFloat2, bnin parambnin)
  {
    return a(ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 }), parambnin, paramLong);
  }
  
  private static ValueAnimator a(ValueAnimator paramValueAnimator, bnin parambnin, long paramLong)
  {
    paramValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    paramValueAnimator.addUpdateListener(new bnil(parambnin));
    paramValueAnimator.addListener(new bnim(parambnin, paramValueAnimator));
    paramValueAnimator.setDuration(paramLong);
    return paramValueAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnik
 * JD-Core Version:    0.7.0.1
 */