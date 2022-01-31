import android.graphics.Point;
import android.view.View;

public class bimi
  implements bimg
{
  public float a(Point paramPoint, int paramInt1, int paramInt2)
  {
    return paramInt1 - paramPoint.x;
  }
  
  public int a(int paramInt)
  {
    return paramInt;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    return paramInt1;
  }
  
  public void a(int paramInt, xfl paramxfl)
  {
    paramxfl.a(paramInt);
  }
  
  public void a(Point paramPoint1, int paramInt, Point paramPoint2)
  {
    paramPoint2.set(paramPoint1.x - paramInt, paramPoint1.y);
  }
  
  public void a(bijy parambijy, int paramInt, Point paramPoint)
  {
    paramPoint.set(paramPoint.x + parambijy.a(paramInt), paramPoint.y);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(Point paramPoint, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = paramPoint.x;
    int i = paramPoint.x;
    return (paramInt2 - paramInt1 < paramInt3 + paramInt4) && (i + paramInt1 > -paramInt4);
  }
  
  public boolean a(bilw parambilw)
  {
    boolean bool = false;
    View localView1 = parambilw.a();
    View localView2 = parambilw.b();
    int i = -parambilw.c();
    int j = parambilw.getWidth();
    int k = parambilw.c();
    if ((parambilw.getDecoratedLeft(localView1) > i) && (parambilw.getPosition(localView1) > 0))
    {
      i = 1;
      if ((parambilw.getDecoratedRight(localView2) >= j + k) || (parambilw.getPosition(localView2) >= parambilw.getItemCount() - 1)) {
        break label102;
      }
    }
    label102:
    for (j = 1;; j = 0)
    {
      if ((i != 0) || (j != 0)) {
        bool = true;
      }
      return bool;
      i = 0;
      break;
    }
  }
  
  public int b(int paramInt)
  {
    return 0;
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    return paramInt1;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public int c(int paramInt1, int paramInt2)
  {
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bimi
 * JD-Core Version:    0.7.0.1
 */