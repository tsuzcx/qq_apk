import android.graphics.PointF;
import android.view.animation.Interpolator;

public class auxb
  implements Interpolator
{
  protected PointF a;
  protected PointF b;
  protected PointF c = new PointF();
  protected PointF d = new PointF();
  protected PointF e = new PointF();
  
  public auxb(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this((float)paramDouble1, (float)paramDouble2, (float)paramDouble3, (float)paramDouble4);
  }
  
  public auxb(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this(new PointF(paramFloat1, paramFloat2), new PointF(paramFloat3, paramFloat4));
  }
  
  public auxb(PointF paramPointF1, PointF paramPointF2)
  {
    if ((paramPointF1.x < 0.0F) || (paramPointF1.x > 1.0F)) {
      throw new IllegalArgumentException("startX value must be in the range [0, 1]");
    }
    if ((paramPointF2.x < 0.0F) || (paramPointF2.x > 1.0F)) {
      throw new IllegalArgumentException("endX value must be in the range [0, 1]");
    }
    this.a = paramPointF1;
    this.b = paramPointF2;
  }
  
  private float c(float paramFloat)
  {
    return this.e.x + (2.0F * this.d.x + 3.0F * this.c.x * paramFloat) * paramFloat;
  }
  
  private float d(float paramFloat)
  {
    this.e.x = (this.a.x * 3.0F);
    this.d.x = ((this.b.x - this.a.x) * 3.0F - this.e.x);
    this.c.x = (1.0F - this.e.x - this.d.x);
    return (this.e.x + (this.d.x + this.c.x * paramFloat) * paramFloat) * paramFloat;
  }
  
  protected float a(float paramFloat)
  {
    this.e.y = (this.a.y * 3.0F);
    this.d.y = ((this.b.y - this.a.y) * 3.0F - this.e.y);
    this.c.y = (1.0F - this.e.y - this.d.y);
    return (this.e.y + (this.d.y + this.c.y * paramFloat) * paramFloat) * paramFloat;
  }
  
  protected float b(float paramFloat)
  {
    int i = 1;
    float f1 = paramFloat;
    for (;;)
    {
      float f2;
      if (i < 14)
      {
        f2 = d(f1) - paramFloat;
        if (Math.abs(f2) >= 0.001D) {}
      }
      else
      {
        return f1;
      }
      f1 -= f2 / c(f1);
      i += 1;
    }
  }
  
  public float getInterpolation(float paramFloat)
  {
    return a(b(paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxb
 * JD-Core Version:    0.7.0.1
 */