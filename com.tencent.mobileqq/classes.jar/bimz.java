import android.graphics.Point;
import android.view.View;

public class bimz
  implements bimx
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
  
  public void a(int paramInt, xfi paramxfi)
  {
    paramxfi.a(paramInt);
  }
  
  public void a(Point paramPoint1, int paramInt, Point paramPoint2)
  {
    paramPoint2.set(paramPoint1.x - paramInt, paramPoint1.y);
  }
  
  public void a(bikp parambikp, int paramInt, Point paramPoint)
  {
    paramPoint.set(paramPoint.x + parambikp.a(paramInt), paramPoint.y);
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
  
  public boolean a(bimn parambimn)
  {
    boolean bool = false;
    View localView1 = parambimn.a();
    View localView2 = parambimn.b();
    int i = -parambimn.c();
    int j = parambimn.getWidth();
    int k = parambimn.c();
    if ((parambimn.getDecoratedLeft(localView1) > i) && (parambimn.getPosition(localView1) > 0))
    {
      i = 1;
      if ((parambimn.getDecoratedRight(localView2) >= j + k) || (parambimn.getPosition(localView2) >= parambimn.getItemCount() - 1)) {
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
 * Qualified Name:     bimz
 * JD-Core Version:    0.7.0.1
 */