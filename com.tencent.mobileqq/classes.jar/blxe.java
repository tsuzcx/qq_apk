import android.graphics.RectF;

public class blxe
  extends blwt
{
  private float a;
  private float b;
  
  public blxe(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  void a(int paramInt, blwu paramblwu)
  {
    float f3 = paramblwu.a.right;
    float f4 = paramblwu.a.left;
    float f1 = paramblwu.a.bottom;
    float f2 = paramblwu.a.top;
    f3 = Math.abs(f3 - f4 - this.a) / 2.0F;
    f1 = Math.abs(f1 - f2 - this.b) / 2.0F;
    RectF localRectF = paramblwu.a;
    localRectF.left += f3;
    paramblwu = paramblwu.a;
    paramblwu.right = (f3 + paramblwu.right);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blxe
 * JD-Core Version:    0.7.0.1
 */