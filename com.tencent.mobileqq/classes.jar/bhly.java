import android.graphics.RectF;

public class bhly
  extends bhln
{
  private float a;
  private float b;
  
  public bhly(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  void a(int paramInt, bhlo parambhlo)
  {
    float f3 = parambhlo.a.right;
    float f4 = parambhlo.a.left;
    float f1 = parambhlo.a.bottom;
    float f2 = parambhlo.a.top;
    f3 = Math.abs(f3 - f4 - this.a) / 2.0F;
    f1 = Math.abs(f1 - f2 - this.b) / 2.0F;
    RectF localRectF = parambhlo.a;
    localRectF.left += f3;
    parambhlo = parambhlo.a;
    parambhlo.right = (f3 + parambhlo.right);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhly
 * JD-Core Version:    0.7.0.1
 */