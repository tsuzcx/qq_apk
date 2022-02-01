import android.graphics.RectF;

public class bptd
  extends bprs
{
  private int a;
  
  public bptd(int paramInt)
  {
    this.a = paramInt;
  }
  
  void a(int paramInt, bprt parambprt)
  {
    RectF localRectF = parambprt.a;
    localRectF.top += this.a * paramInt;
    parambprt = parambprt.a;
    parambprt.bottom += this.a * paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bptd
 * JD-Core Version:    0.7.0.1
 */