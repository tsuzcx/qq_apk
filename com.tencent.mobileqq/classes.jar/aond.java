import android.view.animation.Interpolator;

class aond
  implements Interpolator
{
  aond(aomx paramaomx) {}
  
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return 1.0F - paramFloat * (paramFloat * paramFloat * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aond
 * JD-Core Version:    0.7.0.1
 */