import android.graphics.RectF;

public class blts
  extends blsh
{
  private int a;
  
  public blts(int paramInt)
  {
    this.a = paramInt;
  }
  
  void a(int paramInt, blsi paramblsi)
  {
    RectF localRectF = paramblsi.a;
    localRectF.top += this.a * paramInt;
    paramblsi = paramblsi.a;
    paramblsi.bottom += this.a * paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blts
 * JD-Core Version:    0.7.0.1
 */