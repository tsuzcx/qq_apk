import android.view.animation.Interpolator;

public final class ammi
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    return paramFloat * paramFloat * paramFloat * paramFloat * paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ammi
 * JD-Core Version:    0.7.0.1
 */