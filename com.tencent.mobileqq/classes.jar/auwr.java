import android.view.animation.Interpolator;

final class auwr
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat <= 0.3333333F) {
      return 0.0F;
    }
    return (paramFloat - 0.3333333F) * 1.5F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auwr
 * JD-Core Version:    0.7.0.1
 */