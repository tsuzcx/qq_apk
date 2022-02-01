import android.graphics.RectF;

public class bolb
  extends bokq
{
  private float a;
  private float b;
  
  public bolb(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  void a(int paramInt, bokr parambokr)
  {
    float f3 = parambokr.a.right;
    float f4 = parambokr.a.left;
    float f1 = parambokr.a.bottom;
    float f2 = parambokr.a.top;
    f3 = Math.abs(f3 - f4 - this.a) / 2.0F;
    f1 = Math.abs(f1 - f2 - this.b) / 2.0F;
    RectF localRectF = parambokr.a;
    localRectF.left += f3;
    parambokr = parambokr.a;
    parambokr.right = (f3 + parambokr.right);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bolb
 * JD-Core Version:    0.7.0.1
 */