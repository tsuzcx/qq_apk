import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.animation.AccelerateDecelerateInterpolator;

@TargetApi(11)
public class bpkd
{
  public static ValueAnimator a(long paramLong, float paramFloat1, float paramFloat2, bpkg parambpkg)
  {
    return a(ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 }), parambpkg, paramLong);
  }
  
  private static ValueAnimator a(ValueAnimator paramValueAnimator, bpkg parambpkg, long paramLong)
  {
    paramValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    paramValueAnimator.addUpdateListener(new bpke(parambpkg));
    paramValueAnimator.addListener(new bpkf(parambpkg, paramValueAnimator));
    paramValueAnimator.setDuration(paramLong);
    return paramValueAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpkd
 * JD-Core Version:    0.7.0.1
 */