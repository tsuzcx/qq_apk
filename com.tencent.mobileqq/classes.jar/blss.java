import android.graphics.RectF;

public class blss
  extends blsh
{
  private float a;
  private float b;
  
  public blss(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  void a(int paramInt, blsi paramblsi)
  {
    float f3 = paramblsi.a.right;
    float f4 = paramblsi.a.left;
    float f1 = paramblsi.a.bottom;
    float f2 = paramblsi.a.top;
    f3 = Math.abs(f3 - f4 - this.a) / 2.0F;
    f1 = Math.abs(f1 - f2 - this.b) / 2.0F;
    RectF localRectF = paramblsi.a;
    localRectF.left += f3;
    paramblsi = paramblsi.a;
    paramblsi.right = (f3 + paramblsi.right);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blss
 * JD-Core Version:    0.7.0.1
 */