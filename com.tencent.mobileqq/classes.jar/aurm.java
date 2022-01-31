import android.content.res.Resources;
import android.graphics.Bitmap;

public class aurm
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
  
  public static aurm a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, int paramInt, Resources paramResources)
  {
    aurm localaurm = new aurm();
    localaurm.jdField_d_of_type_Int = paramInt;
    float f = paramBitmap.getHeight() / paramBitmap.getWidth();
    if (paramInt == 0) {}
    for (localaurm.jdField_a_of_type_Int = actn.a(30.0F, paramResources);; localaurm.jdField_a_of_type_Int = actn.a(22.0F, paramResources))
    {
      localaurm.jdField_b_of_type_Int = ((int)(f * localaurm.jdField_a_of_type_Int));
      localaurm.jdField_a_of_type_ArrayOfFloat = new float[2];
      localaurm.jdField_a_of_type_ArrayOfFloat[0] = paramFloat1;
      localaurm.jdField_a_of_type_ArrayOfFloat[1] = paramFloat2;
      localaurm.jdField_a_of_type_Float = ((float)Math.random() * actn.a(18.0F, paramResources) - actn.a(9.0F, paramResources));
      localaurm.jdField_a_of_type_Double = (Math.random() * 3.141592653589793D / 6.0D + 1.308996938995747D);
      localaurm.jdField_b_of_type_Float = (actn.a(150.0F, paramResources) + (float)Math.random() * actn.a(50.0F, paramResources));
      localaurm.jdField_c_of_type_Float = ((float)(localaurm.jdField_b_of_type_Float * Math.cos(localaurm.jdField_a_of_type_Double)));
      localaurm.jdField_d_of_type_Float = ((float)(localaurm.jdField_b_of_type_Float * Math.sin(localaurm.jdField_a_of_type_Double)));
      localaurm.jdField_c_of_type_Int = 256;
      localaurm.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      return localaurm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aurm
 * JD-Core Version:    0.7.0.1
 */