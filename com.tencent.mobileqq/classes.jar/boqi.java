import android.graphics.RectF;

public class boqi
  extends bopx
{
  private float a;
  private float b;
  
  public boqi(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  void a(int paramInt, bopy parambopy)
  {
    float f3 = parambopy.a.right;
    float f4 = parambopy.a.left;
    float f1 = parambopy.a.bottom;
    float f2 = parambopy.a.top;
    f3 = Math.abs(f3 - f4 - this.a) / 2.0F;
    f1 = Math.abs(f1 - f2 - this.b) / 2.0F;
    RectF localRectF = parambopy.a;
    localRectF.left += f3;
    parambopy = parambopy.a;
    parambopy.right = (f3 + parambopy.right);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boqi
 * JD-Core Version:    0.7.0.1
 */