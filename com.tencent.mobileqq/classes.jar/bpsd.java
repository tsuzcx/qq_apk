import android.graphics.RectF;

public class bpsd
  extends bprs
{
  private float a;
  private float b;
  
  public bpsd(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  void a(int paramInt, bprt parambprt)
  {
    float f3 = parambprt.a.right;
    float f4 = parambprt.a.left;
    float f1 = parambprt.a.bottom;
    float f2 = parambprt.a.top;
    f3 = Math.abs(f3 - f4 - this.a) / 2.0F;
    f1 = Math.abs(f1 - f2 - this.b) / 2.0F;
    RectF localRectF = parambprt.a;
    localRectF.left += f3;
    parambprt = parambprt.a;
    parambprt.right = (f3 + parambprt.right);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpsd
 * JD-Core Version:    0.7.0.1
 */