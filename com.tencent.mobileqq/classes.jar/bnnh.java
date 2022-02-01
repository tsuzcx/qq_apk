import android.animation.TimeInterpolator;

public class bnnh
  implements TimeInterpolator
{
  public float getInterpolation(float paramFloat)
  {
    double d = Math.pow(2.0D, -10.0F * paramFloat);
    return (float)(Math.sin((paramFloat - 0.7F / 4.0F) * 6.283185307179586D / 0.7F) * d + 1.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnnh
 * JD-Core Version:    0.7.0.1
 */