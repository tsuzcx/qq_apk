import android.graphics.Matrix;

public class awaf
{
  private static final Matrix a = new Matrix();
  private static final Matrix b = new Matrix();
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(paramFloat2, Math.min(paramFloat1, paramFloat3));
  }
  
  public static void a(awac paramawac1, awac paramawac2, float paramFloat1, float paramFloat2, awac paramawac3, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    paramawac1.a(paramawac2);
    if (!awac.a(paramawac2.c(), paramawac3.c())) {
      paramawac1.b(b(paramawac2.c(), paramawac3.c(), paramFloat5), paramFloat1, paramFloat2);
    }
    float f2 = paramawac2.d();
    float f3 = paramawac3.d();
    float f1;
    if (Math.abs(f2 - f3) <= 180.0F)
    {
      if (awac.a(f2, f3)) {
        break label189;
      }
      f1 = b(f2, f3, paramFloat5);
    }
    for (;;)
    {
      if (!Float.isNaN(f1)) {
        paramawac1.d(f1, paramFloat1, paramFloat2);
      }
      paramawac1.a(b(0.0F, paramFloat3 - paramFloat1, paramFloat5), b(0.0F, paramFloat4 - paramFloat2, paramFloat5));
      return;
      f1 = f2;
      if (f2 < 0.0F) {
        f1 = f2 + 360.0F;
      }
      f2 = f3;
      if (f3 < 0.0F) {
        f2 = f3 + 360.0F;
      }
      if (!awac.a(f1, f2)) {
        f1 = b(f1, f2, paramFloat5);
      } else {
        label189:
        f1 = (0.0F / 0.0F);
      }
    }
  }
  
  public static void a(awac paramawac1, awac paramawac2, awac paramawac3, float paramFloat)
  {
    a(paramawac1, paramawac2, paramawac2.a(), paramawac2.b(), paramawac3, paramawac3.a(), paramawac3.b(), paramFloat);
  }
  
  public static void a(float[] paramArrayOfFloat, awac paramawac1, awac paramawac2)
  {
    paramawac1.a(a);
    a.invert(b);
    b.mapPoints(paramArrayOfFloat);
    paramawac2.a(a);
    a.mapPoints(paramArrayOfFloat);
  }
  
  public static float b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awaf
 * JD-Core Version:    0.7.0.1
 */