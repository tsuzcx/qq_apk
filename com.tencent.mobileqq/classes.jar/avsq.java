import android.view.animation.Interpolator;

public class avsq
  implements Interpolator
{
  public float a;
  public float b;
  public float c;
  public float d;
  
  private avsq() {}
  
  public avsq(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.c = paramFloat3;
    this.b = paramFloat2;
    this.d = paramFloat4;
  }
  
  public float getInterpolation(float paramFloat)
  {
    return (float)(Math.pow(1.0F - paramFloat, 2.0D) * 3.0D * paramFloat * this.b + 3.0F * (1.0F - paramFloat) * Math.pow(paramFloat, 2.0D) * this.d + Math.pow(paramFloat, 3.0D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avsq
 * JD-Core Version:    0.7.0.1
 */