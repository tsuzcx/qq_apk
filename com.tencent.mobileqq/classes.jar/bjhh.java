import android.graphics.RectF;

public class bjhh
  extends bjgw
{
  private float a;
  private float b;
  
  public bjhh(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  void a(int paramInt, bjgx parambjgx)
  {
    float f3 = parambjgx.a.right;
    float f4 = parambjgx.a.left;
    float f1 = parambjgx.a.bottom;
    float f2 = parambjgx.a.top;
    f3 = Math.abs(f3 - f4 - this.a) / 2.0F;
    f1 = Math.abs(f1 - f2 - this.b) / 2.0F;
    RectF localRectF = parambjgx.a;
    localRectF.left += f3;
    parambjgx = parambjgx.a;
    parambjgx.right = (f3 + parambjgx.right);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjhh
 * JD-Core Version:    0.7.0.1
 */