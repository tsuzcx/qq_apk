import android.graphics.RectF;

public class bmvj
  extends bmuy
{
  private float a;
  private float b;
  
  public bmvj(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  void a(int paramInt, bmuz parambmuz)
  {
    float f3 = parambmuz.a.right;
    float f4 = parambmuz.a.left;
    float f1 = parambmuz.a.bottom;
    float f2 = parambmuz.a.top;
    f3 = Math.abs(f3 - f4 - this.a) / 2.0F;
    f1 = Math.abs(f1 - f2 - this.b) / 2.0F;
    RectF localRectF = parambmuz.a;
    localRectF.left += f3;
    parambmuz = parambmuz.a;
    parambmuz.right = (f3 + parambmuz.right);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvj
 * JD-Core Version:    0.7.0.1
 */