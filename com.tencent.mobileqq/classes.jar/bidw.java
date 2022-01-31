import android.view.animation.Interpolator;

final class bidw
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    return paramFloat * paramFloat * paramFloat * paramFloat * paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bidw
 * JD-Core Version:    0.7.0.1
 */