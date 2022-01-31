import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.animation.AccelerateDecelerateInterpolator;

@TargetApi(11)
public class bkck
{
  public static ValueAnimator a(long paramLong, float paramFloat1, float paramFloat2, bkcn parambkcn)
  {
    return a(ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 }), parambkcn, paramLong);
  }
  
  private static ValueAnimator a(ValueAnimator paramValueAnimator, bkcn parambkcn, long paramLong)
  {
    paramValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    paramValueAnimator.addUpdateListener(new bkcl(parambkcn));
    paramValueAnimator.addListener(new bkcm(parambkcn, paramValueAnimator));
    paramValueAnimator.setDuration(paramLong);
    return paramValueAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkck
 * JD-Core Version:    0.7.0.1
 */