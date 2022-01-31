import android.graphics.RectF;

public class bjih
  extends bjgw
{
  private int a;
  
  public bjih(int paramInt)
  {
    this.a = paramInt;
  }
  
  void a(int paramInt, bjgx parambjgx)
  {
    RectF localRectF = parambjgx.a;
    localRectF.top += this.a * paramInt;
    parambjgx = parambjgx.a;
    parambjgx.bottom += this.a * paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjih
 * JD-Core Version:    0.7.0.1
 */