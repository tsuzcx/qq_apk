import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.animation.AccelerateDecelerateInterpolator;

@TargetApi(11)
public class bmsx
{
  public static ValueAnimator a(long paramLong, float paramFloat1, float paramFloat2, bmta parambmta)
  {
    return a(ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 }), parambmta, paramLong);
  }
  
  private static ValueAnimator a(ValueAnimator paramValueAnimator, bmta parambmta, long paramLong)
  {
    paramValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    paramValueAnimator.addUpdateListener(new bmsy(parambmta));
    paramValueAnimator.addListener(new bmsz(parambmta, paramValueAnimator));
    paramValueAnimator.setDuration(paramLong);
    return paramValueAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmsx
 * JD-Core Version:    0.7.0.1
 */