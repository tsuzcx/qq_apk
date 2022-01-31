import android.content.res.Resources;
import android.graphics.Bitmap;
import java.util.HashMap;

public class awjc
{
  static HashMap<Integer, Bitmap> a;
  public double a;
  public float a;
  public int a;
  public Bitmap a;
  public float[] a;
  float b;
  public int b;
  public float c;
  public float d;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static awjc a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, Resources paramResources)
  {
    awjc localawjc = new awjc();
    float f = paramBitmap.getHeight() / paramBitmap.getWidth();
    localawjc.jdField_a_of_type_Int = ((int)(aekt.a(8.0F, paramResources) + (float)Math.random() * aekt.a(3.0F, paramResources)));
    localawjc.jdField_b_of_type_Int = ((int)(f * localawjc.jdField_a_of_type_Int));
    localawjc.jdField_a_of_type_ArrayOfFloat = new float[2];
    localawjc.jdField_a_of_type_ArrayOfFloat[0] = paramFloat1;
    localawjc.jdField_a_of_type_ArrayOfFloat[1] = paramFloat2;
    localawjc.jdField_a_of_type_Float = ((float)Math.random() * aekt.a(90.0F, paramResources) - aekt.a(45.0F, paramResources));
    localawjc.jdField_a_of_type_Double = (2.0D * Math.random() * 3.141592653589793D - 3.141592653589793D);
    if (localawjc.jdField_a_of_type_Double >= 0.0D) {}
    for (localawjc.jdField_b_of_type_Float = (aekt.a(10.0F, paramResources) + (float)Math.random() * aekt.a(200.0F, paramResources));; localawjc.jdField_b_of_type_Float = (-aekt.a(10.0F, paramResources) - (float)Math.random() * aekt.a(200.0F, paramResources)))
    {
      localawjc.c = ((float)(localawjc.jdField_b_of_type_Float * Math.cos(localawjc.jdField_a_of_type_Double)));
      localawjc.d = ((float)(localawjc.jdField_b_of_type_Float * Math.sin(localawjc.jdField_a_of_type_Double)));
      localawjc.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localawjc.jdField_a_of_type_Int)));
      if (localawjc.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        localawjc.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createScaledBitmap(paramBitmap, localawjc.jdField_a_of_type_Int, localawjc.jdField_b_of_type_Int, true);
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localawjc.jdField_a_of_type_Int), localawjc.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      return localawjc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awjc
 * JD-Core Version:    0.7.0.1
 */