import android.graphics.Matrix;

public class aues
{
  private static final Matrix a = new Matrix();
  private static final Matrix b = new Matrix();
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(paramFloat2, Math.min(paramFloat1, paramFloat3));
  }
  
  public static void a(auep paramauep1, auep paramauep2, float paramFloat1, float paramFloat2, auep paramauep3, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    paramauep1.a(paramauep2);
    if (!auep.a(paramauep2.c(), paramauep3.c())) {
      paramauep1.b(b(paramauep2.c(), paramauep3.c(), paramFloat5), paramFloat1, paramFloat2);
    }
    float f2 = paramauep2.d();
    float f3 = paramauep3.d();
    float f1;
    if (Math.abs(f2 - f3) <= 180.0F)
    {
      if (auep.a(f2, f3)) {
        break label189;
      }
      f1 = b(f2, f3, paramFloat5);
    }
    for (;;)
    {
      if (!Float.isNaN(f1)) {
        paramauep1.d(f1, paramFloat1, paramFloat2);
      }
      paramauep1.a(b(0.0F, paramFloat3 - paramFloat1, paramFloat5), b(0.0F, paramFloat4 - paramFloat2, paramFloat5));
      return;
      f1 = f2;
      if (f2 < 0.0F) {
        f1 = f2 + 360.0F;
      }
      f2 = f3;
      if (f3 < 0.0F) {
        f2 = f3 + 360.0F;
      }
      if (!auep.a(f1, f2)) {
        f1 = b(f1, f2, paramFloat5);
      } else {
        label189:
        f1 = (0.0F / 0.0F);
      }
    }
  }
  
  public static void a(auep paramauep1, auep paramauep2, auep paramauep3, float paramFloat)
  {
    a(paramauep1, paramauep2, paramauep2.a(), paramauep2.b(), paramauep3, paramauep3.a(), paramauep3.b(), paramFloat);
  }
  
  public static void a(float[] paramArrayOfFloat, auep paramauep1, auep paramauep2)
  {
    paramauep1.a(a);
    a.invert(b);
    b.mapPoints(paramArrayOfFloat);
    paramauep2.a(a);
    a.mapPoints(paramArrayOfFloat);
  }
  
  public static float b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aues
 * JD-Core Version:    0.7.0.1
 */