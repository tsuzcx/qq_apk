import android.view.animation.Interpolator;

public class bgtq
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    return (float)Math.tan((paramFloat * 2.0F - 1.0F) / 4.0F * 3.141592653589793D) / 2.0F + 0.5F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgtq
 * JD-Core Version:    0.7.0.1
 */