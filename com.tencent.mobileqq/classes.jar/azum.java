import android.content.res.Resources;
import android.graphics.Bitmap;

public class azum
{
  public double a;
  public float a;
  public int a;
  public long a;
  public Bitmap a;
  public float[] a;
  public float b;
  public int b;
  public float c;
  public int c;
  public float d;
  public int d;
  public float e;
  
  public static Bitmap a(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    return paramBitmap;
  }
  
  public static azum a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, int paramInt, Resources paramResources)
  {
    azum localazum = new azum();
    localazum.jdField_d_of_type_Int = paramInt;
    float f = paramBitmap.getHeight() / paramBitmap.getWidth();
    if (paramInt == 0) {}
    for (localazum.jdField_a_of_type_Int = agej.a(30.0F, paramResources);; localazum.jdField_a_of_type_Int = agej.a(22.0F, paramResources))
    {
      localazum.jdField_b_of_type_Int = ((int)(f * localazum.jdField_a_of_type_Int));
      localazum.jdField_a_of_type_ArrayOfFloat = new float[2];
      localazum.jdField_a_of_type_ArrayOfFloat[0] = paramFloat1;
      localazum.jdField_a_of_type_ArrayOfFloat[1] = paramFloat2;
      localazum.jdField_a_of_type_Float = ((float)Math.random() * agej.a(18.0F, paramResources) - agej.a(9.0F, paramResources));
      localazum.jdField_a_of_type_Double = (Math.random() * 3.141592653589793D / 6.0D + 1.308996938995747D);
      localazum.jdField_b_of_type_Float = (agej.a(150.0F, paramResources) + (float)Math.random() * agej.a(50.0F, paramResources));
      localazum.jdField_c_of_type_Float = ((float)(localazum.jdField_b_of_type_Float * Math.cos(localazum.jdField_a_of_type_Double)));
      localazum.jdField_d_of_type_Float = ((float)(localazum.jdField_b_of_type_Float * Math.sin(localazum.jdField_a_of_type_Double)));
      localazum.jdField_c_of_type_Int = 256;
      localazum.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      return localazum;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azum
 * JD-Core Version:    0.7.0.1
 */