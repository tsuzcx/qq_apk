import android.view.animation.Interpolator;

class asqk
  implements Interpolator
{
  asqk(asqe paramasqe) {}
  
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return 1.0F - paramFloat * (paramFloat * paramFloat * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqk
 * JD-Core Version:    0.7.0.1
 */