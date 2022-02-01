import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.animation.AccelerateDecelerateInterpolator;

@TargetApi(11)
public class bqly
{
  public static ValueAnimator a(long paramLong, float paramFloat1, float paramFloat2, bqmb parambqmb)
  {
    return a(ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 }), parambqmb, paramLong);
  }
  
  private static ValueAnimator a(ValueAnimator paramValueAnimator, bqmb parambqmb, long paramLong)
  {
    paramValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    paramValueAnimator.addUpdateListener(new bqlz(parambqmb));
    paramValueAnimator.addListener(new bqma(parambqmb, paramValueAnimator));
    paramValueAnimator.setDuration(paramLong);
    return paramValueAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqly
 * JD-Core Version:    0.7.0.1
 */