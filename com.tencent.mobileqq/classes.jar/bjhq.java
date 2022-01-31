import android.graphics.RectF;

public class bjhq
  extends bjgf
{
  private int a;
  
  public bjhq(int paramInt)
  {
    this.a = paramInt;
  }
  
  void a(int paramInt, bjgg parambjgg)
  {
    RectF localRectF = parambjgg.a;
    localRectF.top += this.a * paramInt;
    parambjgg = parambjgg.a;
    parambjgg.bottom += this.a * paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjhq
 * JD-Core Version:    0.7.0.1
 */