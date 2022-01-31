import android.view.animation.Interpolator;

class anwe
  implements Interpolator
{
  anwe(anvy paramanvy) {}
  
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return 1.0F - paramFloat * (paramFloat * paramFloat * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anwe
 * JD-Core Version:    0.7.0.1
 */