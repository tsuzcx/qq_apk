import android.view.animation.Interpolator;

final class blhv
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    return paramFloat * paramFloat * paramFloat * paramFloat * paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blhv
 * JD-Core Version:    0.7.0.1
 */