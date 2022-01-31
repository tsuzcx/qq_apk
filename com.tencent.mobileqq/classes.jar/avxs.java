import android.opengl.Matrix;

public class avxs
{
  public static float[] a = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  public static final float[] b = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  
  public static float[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = paramInt3 / paramInt4;
    float f2 = paramInt1 / paramInt2;
    if (f1 < f2)
    {
      f2 = paramInt4 * f2 / paramInt3;
      f1 = 1.0F;
    }
    for (;;)
    {
      float[] arrayOfFloat = new float[16];
      Matrix.setIdentityM(arrayOfFloat, 0);
      Matrix.scaleM(arrayOfFloat, 0, f2, f1, 1.0F);
      return arrayOfFloat;
      if (f1 > f2)
      {
        f1 = paramInt3 / (f2 * paramInt4);
        f2 = 1.0F;
      }
      else
      {
        f1 = 1.0F;
        f2 = 1.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avxs
 * JD-Core Version:    0.7.0.1
 */