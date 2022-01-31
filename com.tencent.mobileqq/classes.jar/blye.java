import android.graphics.RectF;

public class blye
  extends blwt
{
  private int a;
  
  public blye(int paramInt)
  {
    this.a = paramInt;
  }
  
  void a(int paramInt, blwu paramblwu)
  {
    RectF localRectF = paramblwu.a;
    localRectF.top += this.a * paramInt;
    paramblwu = paramblwu.a;
    paramblwu.bottom += this.a * paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blye
 * JD-Core Version:    0.7.0.1
 */