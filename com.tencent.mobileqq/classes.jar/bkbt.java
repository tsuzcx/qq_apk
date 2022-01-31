import android.graphics.Matrix;
import android.graphics.RectF;

public class bkbt
{
  private static final Matrix a = new Matrix();
  
  public static bkcp a(RectF paramRectF1, RectF paramRectF2)
  {
    bkcp localbkcp = new bkcp(0.0F, 0.0F, 1.0F, 0.0F);
    if (paramRectF1.equals(paramRectF2)) {
      return localbkcp;
    }
    localbkcp.c = Math.max(paramRectF1.width() / paramRectF2.width(), paramRectF1.height() / paramRectF2.height());
    RectF localRectF = new RectF();
    a.setScale(localbkcp.c, localbkcp.c, paramRectF2.centerX(), paramRectF2.centerY());
    a.mapRect(localRectF, paramRectF2);
    localbkcp.a += paramRectF1.centerX() - localRectF.centerX();
    float f = localbkcp.b;
    localbkcp.b = (paramRectF1.centerY() - localRectF.centerY() + f);
    return localbkcp;
  }
  
  public static bkcp a(RectF paramRectF1, RectF paramRectF2, float paramFloat1, float paramFloat2)
  {
    bkcp localbkcp = new bkcp(0.0F, 0.0F, 1.0F, 0.0F);
    if (paramRectF2.contains(paramRectF1)) {}
    RectF localRectF;
    do
    {
      return localbkcp;
      if ((paramRectF2.width() < paramRectF1.width()) && (paramRectF2.height() < paramRectF1.height())) {
        localbkcp.c = Math.min(paramRectF1.width() / paramRectF2.width(), paramRectF1.height() / paramRectF2.height());
      }
      localRectF = new RectF();
      a.setScale(localbkcp.c, localbkcp.c, paramFloat1, paramFloat2);
      a.mapRect(localRectF, paramRectF2);
      if (localRectF.width() < paramRectF1.width()) {
        localbkcp.a += paramRectF1.centerX() - localRectF.centerX();
      }
      while (localRectF.height() < paramRectF1.height())
      {
        paramFloat1 = localbkcp.b;
        localbkcp.b = (paramRectF1.centerY() - localRectF.centerY() + paramFloat1);
        return localbkcp;
        if (localRectF.left > paramRectF1.left) {
          localbkcp.a += paramRectF1.left - localRectF.left;
        } else if (localRectF.right < paramRectF1.right) {
          localbkcp.a += paramRectF1.right - localRectF.right;
        }
      }
      if (localRectF.top > paramRectF1.top)
      {
        paramFloat1 = localbkcp.b;
        localbkcp.b = (paramRectF1.top - localRectF.top + paramFloat1);
        return localbkcp;
      }
    } while (localRectF.bottom >= paramRectF1.bottom);
    paramFloat1 = localbkcp.b;
    localbkcp.b = (paramRectF1.bottom - localRectF.bottom + paramFloat1);
    return localbkcp;
  }
  
  public static void a(RectF paramRectF1, RectF paramRectF2)
  {
    paramRectF2.offset(paramRectF1.centerX() - paramRectF2.centerX(), paramRectF1.centerY() - paramRectF2.centerY());
  }
  
  public static void a(RectF paramRectF1, RectF paramRectF2, float paramFloat)
  {
    a(paramRectF1, paramRectF2, paramFloat, paramFloat, paramFloat, paramFloat);
  }
  
  public static void a(RectF paramRectF1, RectF paramRectF2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramRectF1.isEmpty()) || (paramRectF2.isEmpty())) {
      return;
    }
    float f2 = paramFloat1;
    float f1 = paramFloat3;
    if (paramRectF1.width() < paramFloat1 + paramFloat3)
    {
      f1 = 0.0F;
      f2 = 0.0F;
    }
    paramFloat3 = paramFloat2;
    paramFloat1 = paramFloat4;
    if (paramRectF1.height() < paramFloat2 + paramFloat4)
    {
      paramFloat1 = 0.0F;
      paramFloat3 = 0.0F;
    }
    paramFloat2 = paramRectF1.width();
    paramFloat4 = paramRectF1.height();
    paramFloat2 = Math.min((paramFloat2 - f2 - f1) / paramRectF2.width(), (paramFloat4 - paramFloat3 - paramFloat1) / paramRectF2.height());
    paramRectF2.set(0.0F, 0.0F, paramRectF2.width() * paramFloat2, paramFloat2 * paramRectF2.height());
    paramRectF2.offset(paramRectF1.centerX() + (f2 - f1) / 2.0F - paramRectF2.centerX(), paramRectF1.centerY() + (paramFloat3 - paramFloat1) / 2.0F - paramRectF2.centerY());
  }
  
  public static bkcp b(RectF paramRectF1, RectF paramRectF2, float paramFloat1, float paramFloat2)
  {
    bkcp localbkcp = new bkcp(0.0F, 0.0F, 1.0F, 0.0F);
    if (paramRectF2.contains(paramRectF1)) {}
    RectF localRectF;
    do
    {
      return localbkcp;
      if ((paramRectF2.width() < paramRectF1.width()) || (paramRectF2.height() < paramRectF1.height())) {
        localbkcp.c = Math.max(paramRectF1.width() / paramRectF2.width(), paramRectF1.height() / paramRectF2.height());
      }
      localRectF = new RectF();
      a.setScale(localbkcp.c, localbkcp.c, paramFloat1, paramFloat2);
      a.mapRect(localRectF, paramRectF2);
      if (localRectF.left > paramRectF1.left) {
        localbkcp.a += paramRectF1.left - localRectF.left;
      }
      while (localRectF.top > paramRectF1.top)
      {
        paramFloat1 = localbkcp.b;
        localbkcp.b = (paramRectF1.top - localRectF.top + paramFloat1);
        return localbkcp;
        if (localRectF.right < paramRectF1.right) {
          localbkcp.a += paramRectF1.right - localRectF.right;
        }
      }
    } while (localRectF.bottom >= paramRectF1.bottom);
    paramFloat1 = localbkcp.b;
    localbkcp.b = (paramRectF1.bottom - localRectF.bottom + paramFloat1);
    return localbkcp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkbt
 * JD-Core Version:    0.7.0.1
 */