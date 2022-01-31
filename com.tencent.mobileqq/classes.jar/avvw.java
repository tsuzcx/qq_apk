import android.graphics.Matrix;

public class avvw
{
  private static final Matrix a = new Matrix();
  private static final Matrix b = new Matrix();
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(paramFloat2, Math.min(paramFloat1, paramFloat3));
  }
  
  public static void a(avvt paramavvt1, avvt paramavvt2, float paramFloat1, float paramFloat2, avvt paramavvt3, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    paramavvt1.a(paramavvt2);
    if (!avvt.a(paramavvt2.c(), paramavvt3.c())) {
      paramavvt1.b(b(paramavvt2.c(), paramavvt3.c(), paramFloat5), paramFloat1, paramFloat2);
    }
    float f2 = paramavvt2.d();
    float f3 = paramavvt3.d();
    float f1;
    if (Math.abs(f2 - f3) <= 180.0F)
    {
      if (avvt.a(f2, f3)) {
        break label189;
      }
      f1 = b(f2, f3, paramFloat5);
    }
    for (;;)
    {
      if (!Float.isNaN(f1)) {
        paramavvt1.d(f1, paramFloat1, paramFloat2);
      }
      paramavvt1.a(b(0.0F, paramFloat3 - paramFloat1, paramFloat5), b(0.0F, paramFloat4 - paramFloat2, paramFloat5));
      return;
      f1 = f2;
      if (f2 < 0.0F) {
        f1 = f2 + 360.0F;
      }
      f2 = f3;
      if (f3 < 0.0F) {
        f2 = f3 + 360.0F;
      }
      if (!avvt.a(f1, f2)) {
        f1 = b(f1, f2, paramFloat5);
      } else {
        label189:
        f1 = (0.0F / 0.0F);
      }
    }
  }
  
  public static void a(avvt paramavvt1, avvt paramavvt2, avvt paramavvt3, float paramFloat)
  {
    a(paramavvt1, paramavvt2, paramavvt2.a(), paramavvt2.b(), paramavvt3, paramavvt3.a(), paramavvt3.b(), paramFloat);
  }
  
  public static void a(float[] paramArrayOfFloat, avvt paramavvt1, avvt paramavvt2)
  {
    paramavvt1.a(a);
    a.invert(b);
    b.mapPoints(paramArrayOfFloat);
    paramavvt2.a(a);
    a.mapPoints(paramArrayOfFloat);
  }
  
  public static float b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avvw
 * JD-Core Version:    0.7.0.1
 */