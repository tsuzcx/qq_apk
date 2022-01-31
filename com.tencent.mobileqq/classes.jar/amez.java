import android.view.animation.Interpolator;

public final class amez
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * (paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amez
 * JD-Core Version:    0.7.0.1
 */