import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class aznw
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
  
  public static aznw a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, int paramInt, Resources paramResources)
  {
    aznw localaznw = new aznw();
    localaznw.jdField_d_of_type_Int = paramInt;
    float f = paramBitmap.getHeight() / paramBitmap.getWidth();
    if (paramInt == 0) {}
    for (localaznw.jdField_a_of_type_Int = AIOUtils.dp2px(30.0F, paramResources);; localaznw.jdField_a_of_type_Int = AIOUtils.dp2px(22.0F, paramResources))
    {
      localaznw.jdField_b_of_type_Int = ((int)(f * localaznw.jdField_a_of_type_Int));
      localaznw.jdField_a_of_type_ArrayOfFloat = new float[2];
      localaznw.jdField_a_of_type_ArrayOfFloat[0] = paramFloat1;
      localaznw.jdField_a_of_type_ArrayOfFloat[1] = paramFloat2;
      localaznw.jdField_a_of_type_Float = ((float)Math.random() * AIOUtils.dp2px(18.0F, paramResources) - AIOUtils.dp2px(9.0F, paramResources));
      localaznw.jdField_a_of_type_Double = (Math.random() * 3.141592653589793D / 6.0D + 1.308996938995747D);
      localaznw.jdField_b_of_type_Float = (AIOUtils.dp2px(150.0F, paramResources) + (float)Math.random() * AIOUtils.dp2px(50.0F, paramResources));
      localaznw.jdField_c_of_type_Float = ((float)(localaznw.jdField_b_of_type_Float * Math.cos(localaznw.jdField_a_of_type_Double)));
      localaznw.jdField_d_of_type_Float = ((float)(localaznw.jdField_b_of_type_Float * Math.sin(localaznw.jdField_a_of_type_Double)));
      localaznw.jdField_c_of_type_Int = 256;
      localaznw.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      return localaznw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aznw
 * JD-Core Version:    0.7.0.1
 */