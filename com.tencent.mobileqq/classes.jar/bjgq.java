import android.graphics.RectF;

public class bjgq
  extends bjgf
{
  private float a;
  private float b;
  
  public bjgq(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  void a(int paramInt, bjgg parambjgg)
  {
    float f3 = parambjgg.a.right;
    float f4 = parambjgg.a.left;
    float f1 = parambjgg.a.bottom;
    float f2 = parambjgg.a.top;
    f3 = Math.abs(f3 - f4 - this.a) / 2.0F;
    f1 = Math.abs(f1 - f2 - this.b) / 2.0F;
    RectF localRectF = parambjgg.a;
    localRectF.left += f3;
    parambjgg = parambjgg.a;
    parambjgg.right = (f3 + parambjgg.right);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjgq
 * JD-Core Version:    0.7.0.1
 */