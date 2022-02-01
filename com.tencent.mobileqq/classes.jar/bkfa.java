import android.graphics.Point;
import java.util.ArrayList;

public final class bkfa
{
  ArrayList<Point> a;
  
  public int a()
  {
    return this.a.size();
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > this.a.size() - 1) && (paramInt1 < 0)) {
      return 0;
    }
    if (paramInt2 == 0) {
      return ((Point)this.a.get(paramInt1)).x;
    }
    return ((Point)this.a.get(paramInt1)).y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkfa
 * JD-Core Version:    0.7.0.1
 */