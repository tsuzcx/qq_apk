import android.view.animation.Interpolator;

public class bepr
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    return (float)(1.0D - Math.pow(1.0F - paramFloat, 4.0D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepr
 * JD-Core Version:    0.7.0.1
 */