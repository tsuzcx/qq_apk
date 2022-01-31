import android.view.animation.Interpolator;

public class bcmg
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    return (float)(1.0D - Math.pow(1.0F - paramFloat, 4.0D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcmg
 * JD-Core Version:    0.7.0.1
 */